package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Constraint;
import androidx.constraintlayout.core.dsl.Helper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class Chain extends Helper {
    protected static final Map<Style, String> styleMap;

    /* renamed from: a */
    public Style f1879a;
    protected ArrayList<Ref> references;

    /* loaded from: classes.dex */
    public class Anchor {

        /* renamed from: a */
        public final Constraint.Side f1880a;

        /* renamed from: c */
        public int f1882c;

        /* renamed from: b */
        public Constraint.Anchor f1881b = null;

        /* renamed from: d */
        public int f1883d = Integer.MIN_VALUE;

        public Anchor(Constraint.Side side) {
            this.f1880a = side;
        }

        public void build(StringBuilder sb) {
            if (this.f1881b != null) {
                sb.append(this.f1880a.toString().toLowerCase());
                sb.append(":");
                sb.append(this);
                sb.append(",\n");
            }
        }

        public String getId() {
            return Chain.this.name;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            if (this.f1881b != null) {
                sb.append("'");
                sb.append(this.f1881b.getId());
                sb.append("','");
                sb.append(this.f1881b.f1921a.toString().toLowerCase());
                sb.append("'");
            }
            if (this.f1882c != 0) {
                sb.append(",");
                sb.append(this.f1882c);
            }
            if (this.f1883d != Integer.MIN_VALUE) {
                if (this.f1882c == 0) {
                    sb.append(",0,");
                    sb.append(this.f1883d);
                } else {
                    sb.append(",");
                    sb.append(this.f1883d);
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Style {
        public static final Style PACKED;
        public static final Style SPREAD;
        public static final Style SPREAD_INSIDE;

        /* renamed from: a */
        public static final /* synthetic */ Style[] f1885a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [androidx.constraintlayout.core.dsl.Chain$Style, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r4v1, types: [androidx.constraintlayout.core.dsl.Chain$Style, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r5v1, types: [androidx.constraintlayout.core.dsl.Chain$Style, java.lang.Enum] */
        static {
            ?? r3 = new Enum("PACKED", 0);
            PACKED = r3;
            ?? r4 = new Enum("SPREAD", 1);
            SPREAD = r4;
            ?? r5 = new Enum("SPREAD_INSIDE", 2);
            SPREAD_INSIDE = r5;
            f1885a = new Style[]{r3, r4, r5};
        }

        public static Style valueOf(String str) {
            return (Style) Enum.valueOf(Style.class, str);
        }

        public static Style[] values() {
            return (Style[]) f1885a.clone();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        styleMap = hashMap;
        hashMap.put(Style.SPREAD, "'spread'");
        hashMap.put(Style.SPREAD_INSIDE, "'spread_inside'");
        hashMap.put(Style.PACKED, "'packed'");
    }

    public Chain(String str) {
        super(str, new Helper.HelperType(""));
        this.f1879a = null;
        this.references = new ArrayList<>();
    }

    public Chain addReference(Ref ref) {
        this.references.add(ref);
        this.configMap.put("contains", referencesToString());
        return this;
    }

    public Style getStyle() {
        return this.f1879a;
    }

    public String referencesToString() {
        if (this.references.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("[");
        Iterator<Ref> it = this.references.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void setStyle(Style style) {
        this.f1879a = style;
        this.configMap.put("style", styleMap.get(style));
    }

    public Chain addReference(String str) {
        return addReference(Ref.parseStringToRef(str));
    }
}
