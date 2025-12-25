package p000;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class i93 implements Continuation {

    /* renamed from: a */
    public final /* synthetic */ int f18344a;

    /* renamed from: b */
    public final /* synthetic */ Collection f18345b;

    public /* synthetic */ i93(Collection collection, int i) {
        this.f18344a = i;
        this.f18345b = collection;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object then(Task task) {
        switch (this.f18344a) {
            case 0:
                ArrayList arrayList = new ArrayList();
                Iterator it = this.f18345b.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Task) it.next()).getResult());
                }
                return arrayList;
            default:
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f18345b);
                return Tasks.forResult(arrayList2);
        }
    }
}
