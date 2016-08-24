DESCRIPTION = "Recipe for installing license keys for ssh server"
LICENSE = "MIT"
PR = "r0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Skips do_compile and do_configure steps
inherit bin_package

# Pull files from CVS
SRC_URI += "cvs://${CVSPATH};port=2401;method=pserver;module=yoctofiles_${BPN};tag=v1-0-0"

S = "${WORKDIR}/yoctofiles_${BPN}/"