package com.lml.yyzj.bean.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by liml on 17/3/10.
 */

public class User extends RealmObject {
    @PrimaryKey
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
