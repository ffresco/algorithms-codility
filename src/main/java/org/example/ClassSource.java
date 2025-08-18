package org.example;

import javax.swing.text.StyledEditorKit;

public class ClassSource {

    private Boolean active;

    public ClassSource(Boolean active) {
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
