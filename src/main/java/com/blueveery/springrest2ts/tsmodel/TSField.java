package com.blueveery.springrest2ts.tsmodel;

import com.blueveery.springrest2ts.GenerationContext;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by tomaszw on 30.07.2017.
 */
public class TSField extends TSComplexTypeMember {
    private boolean optional;

    public TSField(String name, TSComplexType owner, TSType type) {
        super(name, owner, type);
    }


    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    @Override
    public void write(GenerationContext generationContext, BufferedWriter writer) throws IOException {
        writer.write(getName());
        TSType type = getType();
        if(type != null) {
            if (optional) {
                writer.write("?");
            }
            writer.write(": ");
            if (type instanceof TSArrowFuncType) {
                type.write(generationContext, writer);
            } else {
                writer.write(type.getName());
            }
        }
        writer.write(";");
    }
}
