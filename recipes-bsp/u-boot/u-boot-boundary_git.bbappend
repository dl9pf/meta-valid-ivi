#use validmfg branch of u-boot instead

SRCREV_mx6 = "173663196b23f597e6c2e367507dd68c0fdb845c"
SRCBRANCH_mx6 = "boundary-v2016.03"
SRC_URI_mx6 = "git://github.com/validmfg/u-boot-imx6.git;branch=${SRCBRANCH}"

# Rename u-boot file for update 
#UBOOT_SUFFIX = "nitrogen6q_som2_1g"

UBOOT_MACHINE = "nitrogen6q_som2_1g_defconfig"

#UBOOT_CONFIG_append = "nitrogen6q_som2_1g"
#UBOOT_CONFIG[nitrogen6q_som2_1g] = "nitrogen6q_som2_1g_config"
#UBOOT_MACHINE = ""
