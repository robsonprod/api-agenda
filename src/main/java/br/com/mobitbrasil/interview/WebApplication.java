package br.com.mobitbrasil.interview;

import lombok.val;

import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Map;


@Stateless
@ApplicationPath("/api/v1")
public class WebApplication extends Application {

    @Override
    public Map<String, Object> getProperties() {
        val properties = super.getProperties();
        properties.put("jersey.config.server.disableMoxyJson", true);
        return properties;
    }
}
