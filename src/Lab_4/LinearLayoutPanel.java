package Lab_4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LinearLayoutPanel {
    private JPanel panel = new JPanel();
    private Orient orient;
    private ArrayList<JComponent> components = new ArrayList<JComponent>();
    private ArrayList<GridBagConstraints> contrainsts = new ArrayList<GridBagConstraints>();

    public LinearLayoutPanel(Orient orient) {
        this.orient = orient;
        panel.setLayout(new GridBagLayout());
    }

    public void add(JComponent component) {
        components.add(component);
        contrainsts.add(new GridBagConstraints());
        notifyConstraints();
    }

    public void add(JComponent...components) {
        for (JComponent component: components) {
            this.components.add(component);
            contrainsts.add(new GridBagConstraints());
            notifyConstraints();
        }
    }

    public void notifyConstraints() {
        switch (orient) {
            case HORIZONTAL -> {
                for(int i = 0; i < contrainsts.size(); i++) {
                    contrainsts.get(i).gridy = i;
                }
            }
            case VERTICAL -> {
                for (int i = 0; i < contrainsts.size(); i++) {
                    contrainsts.get(i).gridx = i;
                }
            }
        }
    }

    public JPanel inflate() {
        for (JComponent component: components) {
            for (GridBagConstraints constraint: contrainsts) {
                panel.add(component, constraint);
            }
        }
        return panel;
    }
}

