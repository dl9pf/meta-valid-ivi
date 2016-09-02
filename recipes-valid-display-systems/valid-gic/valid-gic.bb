DESCRIPTION = "Valid Mfg Dash Distribution Build Recipe"
LICENSE = "MIT"
PR = "r0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit core-image
inherit extrausers

MACHINE = 'nitrogen6x'
DISTRO = 'vgicdist'

IMAGE_INSTALL = " \
		packagegroup-core-boot \
		${ROOTFS_PKGMANAGE_BOOTSTRAP} \
		${CORE_IMAGE_EXTRA_INSTALL} \
		libegl \
		imx-gpu-viv \ 
		libegl-mx6 \
		libgl-mx6 \
		libgles-mx6 \
		libgles2-mx6 \
		alsa-lib \
		alsa-utils \
		gstreamer1.0 \
		gstreamer1.0-plugins-imx \
		gstreamer1.0-plugins-good \
		gstreamer1.0-plugins-good-souphttpsrc \
		openssl \
		openssl-conf \		
		ca-certificates \
		iproute2 \
		imx-gpu-viv \
		cluster \
		validmfg-ssh-keys \
		ethtool \
		canutils \
		libsocketcan \
		linux-imx6yocto-armle-opengles \
		u-boot-boundary \
"

# Debug tweaks sets root passwd to blank
IMAGE_FEATURES_append = " debug-tweaks ssh-server-openssh"
#IMAGE_FEATURES_append = " ssh-server-openssh"

TOOLCHAIN_TARGET_TASK_append = " kernel-devsrc linux-libc-headers"

# Add valid user and set root password
EXTRA_USERS_PARAMS = " \
		useradd -u 1000 -d /home/valid -r -U -s /bin/sh -P '53206477' valid; \
        usermod -P '5320B6477' root; \
"

IMAGE_ROOTFS_EXTRA_SPACE = "50000"

IMAGE_LINGUAS = " "

#Taken from core_image_minimal.bb dynamic file system size allocation...
IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

COMPATIBLE_MACHINE = "nitrogen6x"

CUSTOM_DEFCONFIG ?= ""

do_custom_defconfig () {
  if [ ! -z "${CUSTOM_DEFCONFIG}" ]; then 
		cp ${CUSTOM_DEFCONFIG} ${WORKDIR}/defconfig
	fi
}
addtask do_custom_defconfig after do_patch before do_compile
