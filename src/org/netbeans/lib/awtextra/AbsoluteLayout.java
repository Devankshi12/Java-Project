package org.netbeans.lib.awtextra;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class AbsoluteLayout implements LayoutManager {
    
    private Map<Component, AbsoluteConstraints> constraints = new HashMap<>();
    
    @Override
    public void addLayoutComponent(String name, Component comp) {
        // Not used in this implementation
    }
    
    @Override
    public void removeLayoutComponent(Component comp) {
        constraints.remove(comp);
    }
    
    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return new Dimension(800, 600);
    }
    
    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return new Dimension(400, 300);
    }
    
    @Override
    public void layoutContainer(Container parent) {
        for (Component comp : parent.getComponents()) {
            AbsoluteConstraints ac = constraints.get(comp);
            if (ac != null) {
                comp.setBounds(ac.getX(), ac.getY(), ac.getWidth(), ac.getHeight());
            }
        }
    }
    
    public void addLayoutComponent(Component comp, AbsoluteConstraints constraints) {
        this.constraints.put(comp, constraints);
    }
}
