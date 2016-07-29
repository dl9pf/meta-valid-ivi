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

# Specify tar file to build into image 
SRC_URI = "file://${BP}.tar.gz"

S = "${WORKDIR}/${BP}/"