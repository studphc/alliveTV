package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Constraint;
import androidx.constraintlayout.core.dsl.Helper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class Barrier extends Helper {

    /* renamed from: a */
    public Constraint.Side f1876a;

    /* renamed from: b */
    public int f1877b;

    /* renamed from: c */
    public final ArrayList f1878c;

    public Barrier(String str) {
        super(str, new Helper.HelperType(Helper.typeMap.get(Helper.Type.BARRIER)));
        this.f1876a = null;
        this.f1877b = Integer.MIN_VALUE;
        this.f1878c = new ArrayList();
    }

    public Barrier addReference(Ref ref) {
        this.f1878c.add(ref);
        this.configMap.put("contains", referencesToString());
        return this;
    }

    public Constraint.Side getDirection() {
        return this.f1876a;
    }

    public int getMargin() {
        return this.f1877b;
    }

    public String referencesToString() {
        ArrayList arrayList = this.f1878c;
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("[");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append(((Ref) it.next()).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void setDirection(Constraint.Side side) {
        this.f1876a = side;
        this.configMap.put("direction", Helper.sideMap.get(side));
    }

    public void setMargin(int i) {
        this.f1877b = i;
        this.configMap.put("margin", String.valueOf(i));
    }

    public Barrier addReference(String str) {
        return addReference(Ref.parseStringToRef(str));
    }

    public Barrier(String str, String str2) {
        super(str, new Helper.HelperType(Helper.typeMap.get(Helper.Type.BARRIER)), str2);
        this.f1876a = null;
        this.f1877b = Integer.MIN_VALUE;
        ArrayList arrayList = new ArrayList();
        this.f1878c = arrayList;
        Map<String, String> convertConfigToMap = convertConfigToMap();
        this.configMap = convertConfigToMap;
        if (convertConfigToMap.containsKey("contains")) {
            Ref.addStringToReferences(this.configMap.get("contains"), arrayList);
        }
    }
}
