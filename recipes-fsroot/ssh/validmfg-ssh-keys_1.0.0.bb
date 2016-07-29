DESCRIPTION = "Recipe for installing license keys for ssh server"
LICENSE = "MIT"
PR = "r0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Skips do_compile and do_configure steps
inherit bin_package

# Identify the tar to extract
SRC_URI = "file://${BP}.tar.gz"

S = "${WORKDIR}/${BP}/"
