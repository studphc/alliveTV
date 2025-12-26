package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class KeyFrames {

    /* renamed from: a */
    public final ArrayList f1990a = new ArrayList();

    public void add(Keys keys) {
        this.f1990a.add(keys);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = this.f1990a;
        if (!arrayList.isEmpty()) {
            sb.append("keyFrames:{\n");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append(((Keys) it.next()).toString());
            }
            sb.append("},\n");
        }
        return sb.toString();
    }
}
