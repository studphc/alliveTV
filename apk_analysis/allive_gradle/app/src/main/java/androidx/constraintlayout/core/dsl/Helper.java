package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Constraint;
import java.util.HashMap;
import java.util.Map;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class Helper {
    protected static final Map<Constraint.Side, String> sideMap;
    protected static final Map<Type, String> typeMap;
    protected String config;
    protected Map<String, String> configMap;
    protected final String name;
    protected HelperType type;

    /* loaded from: classes.dex */
    public static final class HelperType {

        /* renamed from: a */
        public final String f1941a;

        public HelperType(String str) {
            this.f1941a = str;
        }

        public String toString() {
            return this.f1941a;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Type {
        public static final Type BARRIER;
        public static final Type HORIZONTAL_CHAIN;
        public static final Type HORIZONTAL_GUIDELINE;
        public static final Type VERTICAL_CHAIN;
        public static final Type VERTICAL_GUIDELINE;

        /* renamed from: a */
        public static final /* synthetic */ Type[] f1942a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [androidx.constraintlayout.core.dsl.Helper$Type, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r6v1, types: [androidx.constraintlayout.core.dsl.Helper$Type, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r7v1, types: [androidx.constraintlayout.core.dsl.Helper$Type, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r8v1, types: [androidx.constraintlayout.core.dsl.Helper$Type, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r9v1, types: [androidx.constraintlayout.core.dsl.Helper$Type, java.lang.Enum] */
        static {
            ?? r5 = new Enum("VERTICAL_GUIDELINE", 0);
            VERTICAL_GUIDELINE = r5;
            ?? r6 = new Enum("HORIZONTAL_GUIDELINE", 1);
            HORIZONTAL_GUIDELINE = r6;
            ?? r7 = new Enum("VERTICAL_CHAIN", 2);
            VERTICAL_CHAIN = r7;
            ?? r8 = new Enum("HORIZONTAL_CHAIN", 3);
            HORIZONTAL_CHAIN = r8;
            ?? r9 = new Enum("BARRIER", 4);
            BARRIER = r9;
            f1942a = new Type[]{r5, r6, r7, r8, r9};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f1942a.clone();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        sideMap = hashMap;
        hashMap.put(Constraint.Side.LEFT, "'left'");
        hashMap.put(Constraint.Side.RIGHT, "'right'");
        hashMap.put(Constraint.Side.TOP, "'top'");
        hashMap.put(Constraint.Side.BOTTOM, "'bottom'");
        hashMap.put(Constraint.Side.START, "'start'");
        hashMap.put(Constraint.Side.END, "'end'");
        hashMap.put(Constraint.Side.BASELINE, "'baseline'");
        HashMap hashMap2 = new HashMap();
        typeMap = hashMap2;
        hashMap2.put(Type.VERTICAL_GUIDELINE, "vGuideline");
        hashMap2.put(Type.HORIZONTAL_GUIDELINE, "hGuideline");
        hashMap2.put(Type.VERTICAL_CHAIN, "vChain");
        hashMap2.put(Type.HORIZONTAL_CHAIN, "hChain");
        hashMap2.put(Type.BARRIER, "barrier");
    }

    public Helper(String str, HelperType helperType) {
        this.type = null;
        this.configMap = new HashMap();
        this.name = str;
        this.type = helperType;
    }

    public static void main(String[] strArr) {
        System.out.println(new Barrier("abc", "['a1', 'b2']").toString());
    }

    public void append(Map<String, String> map, StringBuilder sb) {
        if (map.isEmpty()) {
            return;
        }
        for (String str : map.keySet()) {
            sb.append(str);
            sb.append(":");
            sb.append(map.get(str));
            sb.append(",\n");
        }
    }

    public Map<String, String> convertConfigToMap() {
        String str = this.config;
        if (str != null && str.length() != 0) {
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            String str2 = "";
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.config.length(); i3++) {
                char charAt = this.config.charAt(i3);
                if (charAt == ':') {
                    str2 = sb.toString();
                    sb.setLength(0);
                } else if (charAt == ',' && i == 0 && i2 == 0) {
                    hashMap.put(str2, sb.toString());
                    sb.setLength(0);
                    str2 = "";
                } else if (charAt != ' ') {
                    if (charAt != '[') {
                        if (charAt == ']') {
                            i--;
                        } else if (charAt != '{') {
                            if (charAt == '}') {
                                i2--;
                            }
                        } else {
                            i2++;
                        }
                    } else {
                        i++;
                    }
                    sb.append(charAt);
                }
            }
            hashMap.put(str2, sb.toString());
            return hashMap;
        }
        return null;
    }

    public String getConfig() {
        return this.config;
    }

    public String getId() {
        return this.name;
    }

    public HelperType getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(AbstractC1726qj.m7061q(new StringBuilder(), this.name, ":{\n"));
        if (this.type != null) {
            sb.append("type:'");
            sb.append(this.type.toString());
            sb.append("',\n");
        }
        Map<String, String> map = this.configMap;
        if (map != null) {
            append(map, sb);
        }
        sb.append("},\n");
        return sb.toString();
    }

    public Helper(String str, HelperType helperType, String str2) {
        this.type = null;
        this.configMap = new HashMap();
        this.name = str;
        this.type = helperType;
        this.config = str2;
        this.configMap = convertConfigToMap();
    }
}
