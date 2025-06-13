FROM quay.io/keycloak/keycloak:26.2.5
COPY realm-export.json /opt/keycloak/data/import/
ENV KC_HEALTH_ENABLED=true
ENV KC_METRICS_ENABLED=true
CMD ["start-dev", "--import-realm"]