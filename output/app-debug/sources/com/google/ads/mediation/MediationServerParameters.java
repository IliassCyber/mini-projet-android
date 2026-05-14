package com.google.ads.mediation;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class MediationServerParameters {

    public static final class MappingException extends Exception {
        public MappingException(String str) {
            super(str);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Parameter {
        String name();

        boolean required() default true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void load(Map<String, String> map) throws MappingException {
        StringBuilder sb;
        String str;
        HashMap map2 = new HashMap();
        for (Field field : getClass().getFields()) {
            Parameter parameter = (Parameter) field.getAnnotation(Parameter.class);
            if (parameter != null) {
                map2.put(parameter.name(), field);
            }
        }
        if (map2.isEmpty()) {
            zzb.zzaC("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Field field2 = (Field) map2.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                } catch (IllegalAccessException e) {
                    sb = new StringBuilder();
                    sb.append("Server option \"");
                    sb.append(entry.getKey());
                    str = "\" could not be set: Illegal Access";
                    sb.append(str);
                    zzb.zzaC(sb.toString());
                } catch (IllegalArgumentException e2) {
                    sb = new StringBuilder();
                    sb.append("Server option \"");
                    sb.append(entry.getKey());
                    str = "\" could not be set: Bad Type";
                    sb.append(str);
                    zzb.zzaC(sb.toString());
                }
            } else {
                zzb.zzay("Unexpected server option: " + entry.getKey() + " = \"" + entry.getValue() + "\"");
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (Field field3 : map2.values()) {
            if (((Parameter) field3.getAnnotation(Parameter.class)).required()) {
                zzb.zzaC("Required server option missing: " + ((Parameter) field3.getAnnotation(Parameter.class)).name());
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                sb2.append(((Parameter) field3.getAnnotation(Parameter.class)).name());
            }
        }
        if (sb2.length() <= 0) {
            zzz();
            return;
        }
        throw new MappingException("Required server option(s) missing: " + sb2.toString());
    }

    protected void zzz() {
    }
}
