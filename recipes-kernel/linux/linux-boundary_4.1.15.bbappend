# Add local folder to files path (prepend so it looks here for defonfig first)
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# Apply patches
SRC_URI += "file://enable_gp_enet_phy_reset.patch"
SRC_URI += "file://enet_revert.patch"
SRC_URI += "file://linux_phy_som2.patch"

# Use this defconfig instead of default one
SRC_URI += "file://defconfig"

IMAGE_INSTALL_append = " kernel-devsrc"
TOOLCHAIN_TARGET_TASK_append = " kernel-devsrc"