package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Chain;
import androidx.constraintlayout.core.dsl.Constraint;
import androidx.constraintlayout.core.dsl.Helper;
import java.util.Map;

/* loaded from: classes.dex */
public class VChain extends Chain {

    /* renamed from: b */
    public final VAnchor f2044b;

    /* renamed from: c */
    public final VAnchor f2045c;

    /* renamed from: d */
    public final VAnchor f2046d;

    /* loaded from: classes.dex */
    public class VAnchor extends Chain.Anchor {
        public VAnchor(VChain vChain, Constraint.VSide vSide) {
            super(Constraint.Side.valueOf(vSide.name()));
        }
    }

    public VChain(String str) {
        super(str);
        this.f2044b = new VAnchor(this, Constraint.VSide.TOP);
        this.f2045c = new VAnchor(this, Constraint.VSide.BOTTOM);
        this.f2046d = new VAnchor(this, Constraint.VSide.BASELINE);
        this.type = new Helper.HelperType(Helper.typeMap.get(Helper.Type.VERTICAL_CHAIN));
    }

    public VAnchor getBaseline() {
        return this.f2046d;
    }

    public VAnchor getBottom() {
        return this.f2045c;
    }

    public VAnchor getTop() {
        return this.f2044b;
    }

    public void linkToBaseline(Constraint.VAnchor vAnchor) {
        linkToBaseline(vAnchor, 0);
    }

    public void linkToBottom(Constraint.VAnchor vAnchor) {
        linkToBottom(vAnchor, 0);
    }

    public void linkToTop(Constraint.VAnchor vAnchor) {
        linkToTop(vAnchor, 0);
    }

    public void linkToBaseline(Constraint.VAnchor vAnchor, int i) {
        linkToBaseline(vAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToBottom(Constraint.VAnchor vAnchor, int i) {
        linkToBottom(vAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToTop(Constraint.VAnchor vAnchor, int i) {
        linkToTop(vAnchor, i, Integer.MIN_VALUE);
    }

    public void linkToBaseline(Constraint.VAnchor vAnchor, int i, int i2) {
        VAnchor vAnchor2 = this.f2046d;
        vAnchor2.f1881b = vAnchor;
        vAnchor2.f1882c = i;
        vAnchor2.f1883d = i2;
        this.configMap.put("baseline", vAnchor2.toString());
    }

    public void linkToBottom(Constraint.VAnchor vAnchor, int i, int i2) {
        VAnchor vAnchor2 = this.f2045c;
        vAnchor2.f1881b = vAnchor;
        vAnchor2.f1882c = i;
        vAnchor2.f1883d = i2;
        this.configMap.put("bottom", vAnchor2.toString());
    }

    public void linkToTop(Constraint.VAnchor vAnchor, int i, int i2) {
        VAnchor vAnchor2 = this.f2044b;
        vAnchor2.f1881b = vAnchor;
        vAnchor2.f1882c = i;
        vAnchor2.f1883d = i2;
        this.configMap.put("top", vAnchor2.toString());
    }

    public VChain(String str, String str2) {
        super(str);
        this.f2044b = new VAnchor(this, Constraint.VSide.TOP);
        this.f2045c = new VAnchor(this, Constraint.VSide.BOTTOM);
        this.f2046d = new VAnchor(this, Constraint.VSide.BASELINE);
        this.config = str2;
        this.type = new Helper.HelperType(Helper.typeMap.get(Helper.Type.VERTICAL_CHAIN));
        Map<String, String> convertConfigToMap = convertConfigToMap();
        this.configMap = convertConfigToMap;
        if (convertConfigToMap.containsKey("contains")) {
            Ref.addStringToReferences(this.configMap.get("contains"), this.references);
        }
    }
}
