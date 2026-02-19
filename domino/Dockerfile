ARG BASEIMAGE
FROM ${BASEIMAGE}

COPY notesdata.zip /local/
COPY domino-config.json /local/
COPY --chown=notes keychain.p12 /local/
COPY --chown=notes nomad.crt /local/
COPY --chown=notes privateKey.pem /local/
COPY --chown=notes configoidcp.ntf /local/