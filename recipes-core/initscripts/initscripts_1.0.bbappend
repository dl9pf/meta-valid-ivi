FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_mx6 = " file://cluster.sh "

inherit update-alternatives
DEPENDS_append = " update-rc.d-native"

do_install_append_mx6() {

    # Install device dependent scripts
	install -m 0755 ${WORKDIR}/cluster.sh	${D}${sysconfdir}/init.d/cluster.sh

    # Create runlevel links
	update-rc.d -r ${D} cluster.sh start 04 S .    
}

MASKED_SCRIPTS_append = " cluster"