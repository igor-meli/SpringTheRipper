package com.mielientiev.screensaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

public class PeriodicalScopeConfigurer implements Scope {

    private Map<String, Pair<Long, Object>> map = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (map.containsKey(name)) {
            Pair<Long, Object> pair = map.get(name);
            long millSinceLastRequest = System.currentTimeMillis() - pair.getKey();
            if (millSinceLastRequest > 5000) {
                map.put(name, new Pair<>(System.currentTimeMillis(), objectFactory.getObject()));
            }
        } else {
            map.put(name, new Pair<>(System.currentTimeMillis(), objectFactory.getObject()));
        }
        return map.get(name).getValue();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
