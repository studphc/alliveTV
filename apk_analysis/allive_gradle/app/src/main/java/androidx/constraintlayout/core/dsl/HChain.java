package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Chain;
import androidx.constraintlayout.core.dsl.Constraint;
import androidx.constraintlayout.core.dsl.Helper;
import java.util.Map;

/* loaded from: classes.dex */
public class HChain extends Chain {

    /* renamed from: b */
    public final HAnchor f1937b;

    /* renamed from: c */
    public final HAnchor f1938c;

    /* renamed from: d */
    public final HAnchor f1939d;

    /* renamed from: e */
    public final HAnchor f1940e;

    /* loaded from: classes.dex */
    public class HAnchor extends Chain.Anchor {
        public HAnchor(HChain hChain, Constraint.HSide hSide) {
            super(Constraint.Side.valueOf(hSide.name()));
        }
    }

    public HChain(String str) {
        super(str);
        this.f1937b = new HAnchor(this, Constraint.HSide.LEFT);
        this.f1938c = new HAnchor(this, Constraint.HSide.RIGHT);
        this.f1939d = new HAnchor(this, Constraint.HSide.START);
        this.f1940e = new HAnchor(this, Constraint.HSide.END);
        this.type = new Helper.HelperType(Helper.typeMap.get(Helper.Type.HORIZONTAL_CHAIN));
    }

    public HAnchor getEnd() {
        return this.f1940e;
    }

    public HAnchor getLeft() {
        return this.f1937b;
    }

    public HAnchor getRight() {
        return this.f1938c;
    }

    public HAnchor getStart() {
        return this.f1939d;
    }

    public void linkToEnd(Constraint.HAnchor hAnchor) {
        linkToEnd(hAnchor, 0);
    }

    public void linkToLeft(Constraint.HAnchor hAnchor) {
        linkToLeft(hAnchor, 0);
    }

    public void linkToRight(Constraint.HAnchor hAnchor) {
        linkToRight(hAnchor, 0);
    }

    public void linkToStart(Constraint.HAnchor hAnchor) {
        linkToStart(hAnchor, 0);
    }

    public void linkToEnd(Constraint.HAnchor hAnchor, int i) {
        linkToEnd(hAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToLeft(Constraint.HAnchor hAnchor, int i) {
        linkToLeft(hAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToRight(Constraint.HAnchor hAnchor, int i) {
        linkToRight(hAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToStart(Constraint.HAnchor hAnchor, int i) {
        linkToStart(hAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToEnd(Constraint.HAnchor hAnchor, int i, int i2) {
        HAnchor hAnchor2 = this.f1940e;
        hAnchor2.f1881b = hAnchor;
        hAnchor2.f1882c = i;
        hAnchor2.f1883d = i2;
        this.configMap.put("end", hAnchor2.toString());
    }

    public void linkToLeft(Constraint.HAnchor hAnchor, int i, int i2) {
        HAnchor hAnchor2 = this.f1937b;
        hAnchor2.f1881b = hAnchor;
        hAnchor2.f1882c = i;
        hAnchor2.f1883d = i2;
        this.configMap.put("left", hAnchor2.toString());
    }

    public void linkToRight(Constraint.HAnchor hAnchor, int i, int i2) {
        HAnchor hAnchor2 = this.f1938c;
        hAnchor2.f1881b = hAnchor;
        hAnchor2.f1882c = i;
        hAnchor2.f1883d = i2;
        this.configMap.put("right", hAnchor2.toString());
    }

    public void linkToStart(Constraint.HAnchor hAnchor, int i, int i2) {
        HAnchor hAnchor2 = this.f1939d;
        hAnchor2.f1881b = hAnchor;
        hAnchor2.f1882c = i;
        hAnchor2.f1883d = i2;
        this.configMap.put("start", hAnchor2.toString());
    }

    public HChain(String str, String str2) {
        super(str);
        this.f1937b = new HAnchor(this, Constraint.HSide.LEFT);
        this.f1938c = new HAnchor(this, Constraint.HSide.RIGHT);
        this.f1939d = new HAnchor(this, Constraint.HSide.START);
        this.f1940e = new HAnchor(this, Constraint.HSide.END);
        this.config = str2;
        this.type = new Helper.HelperType(Helper.typeMap.get(Helper.Type.HORIZONTAL_CHAIN));
        Map<String, String> convertConfigToMap = convertConfigToMap();
        this.configMap = convertConfigToMap;
        if (convertConfigToMap.containsKey("contains")) {
            Ref.addStringToReferences(this.configMap.get("contains"), this.references);
        }
    }
}
