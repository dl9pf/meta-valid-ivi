#use validmfg branch of u-boot instead

SRCREV_mx6 = "d715e00d7f3d311127705ac626a4fab4eddab398"
SRCBRANCH_mx6 = "boundary-v2016.03"
SRC_URI_mx6 = "git://github.com/validmfg/u-boot-imx6.git;branch=${SRCBRANCH}"

BOOTSCRIPT = "${S}/board/boundary/nitrogen6x/6x_bootscript-valid.txt"