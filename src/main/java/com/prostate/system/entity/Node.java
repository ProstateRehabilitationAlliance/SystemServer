package com.prostate.system.entity;

import java.util.List;

/**
 * @Author: developerfengrui
 * @Description:
 * @Date: Created in 14:59 2018/5/2
 */
public class Node {

    private String id;
    private String text;
    private List<Node> children;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", children='" + children + '\'' +
                '}';
    }
}
