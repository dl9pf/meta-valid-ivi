DESCRIPTION = "Recipe for instalation of cluster files"
LICENSE = "MIT"
PR = "r0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Skips do_compile and do_configure steps
inherit bin_package

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

# This package depends on libasound
RRECOMMENDS_${PN}_append = "alsa-lib"

# Add linux-imx6yocto-armle-opengles_2.0 (contains sbengine) - if we can resolve the dependancy version issues
# DEPENDS += "linux-imx6yocto-armle-opengles"

# Pull files from CVS
SRC_URI += "cvs://${CVSPATH};port=2401;method=pserver;module=yoctofiles_${BPN};date=now"

S = "${WORKDIR}/yoctofiles_${BPN}/"

ALLOW_EMPTY_${PN} = "1"

do_install_prepend() {
    install -m 0755 -d ${D}/home/valid
}

