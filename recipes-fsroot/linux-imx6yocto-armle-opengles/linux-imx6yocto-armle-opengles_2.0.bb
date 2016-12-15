DESCRIPTION = "Recipe for instalation of storyboard engine"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Skips do_compile and do_configure steps
inherit bin_package

# Add linux-imx6yocto-armle-opengles_2.0 (contains sbengine)
RRECOMMENDS_${PN}_append = "imx-gpu-viv"

# Do not split and strip package
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

INSANE_SKIP_${PN} = "staticdev textrel"

# Pull files from CVS
SRC_URI += "cvs://${CVSPATH};port=2401;method=pserver;module=yoctofiles_${BPN};tag=v2-0"

S = "${WORKDIR}/yoctofiles_${BPN}/"