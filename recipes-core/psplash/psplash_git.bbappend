# Prepend directory so that it uses this psplash-init and psplash-poky-img.h instead 
FILESEXTRAPATHS_prepend_mx6 := "${THISDIR}/valid:"

#Patch the source so that it doesn't have a progress bar
SRC_URI_append_mx6 = " file://remove_progress_and_msg.patch"

#Override SRCREV to version with fbdev option
SRCREV_mx6 = "5b3c1cc28f5abdc2c33830150b48b278cc4f7bca"

DEPENDS_append_mx6 = " virtual/kernel"

CFLAGS_append_mx6 = " \
        -I${STAGING_KERNEL_DIR}/include/uapi \
        -I${STAGING_KERNEL_DIR}/include \
"
