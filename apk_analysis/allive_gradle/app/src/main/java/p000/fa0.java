package p000;

import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.video.spherical.Projection$SubMesh;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class fa0 {

    /* renamed from: a */
    public final Object f17187a;

    /* renamed from: b */
    public int f17188b;

    /* renamed from: c */
    public int f17189c;

    /* renamed from: d */
    public Object f17190d;

    public fa0(HashMap hashMap) {
        this.f17190d = hashMap;
        this.f17187a = new ArrayList(hashMap.keySet());
        for (Integer num : hashMap.values()) {
            this.f17188b = num.intValue() + this.f17188b;
        }
    }

    /* renamed from: a */
    public void m4789a(Exception exception) {
        Throwable initCause;
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.f17189c++;
        ArrayList arrayList = (ArrayList) this.f17187a;
        if (arrayList.size() < this.f17188b) {
            if (((Path) this.f17190d) != null) {
                AbstractC1557mq.m6228q();
                initCause = AbstractC1557mq.m6225n(String.valueOf((Path) this.f17190d)).initCause(exception);
                Intrinsics.checkNotNull(initCause, "null cannot be cast to non-null type java.nio.file.FileSystemException");
                exception = AbstractC1557mq.m6226o(initCause);
            }
            arrayList.add(exception);
        }
    }

    public fa0(Projection$SubMesh projection$SubMesh) {
        this.f17188b = projection$SubMesh.getVertexCount();
        this.f17187a = GlUtil.createBuffer(projection$SubMesh.vertices);
        this.f17190d = GlUtil.createBuffer(projection$SubMesh.textureCoords);
        int i = projection$SubMesh.mode;
        if (i == 1) {
            this.f17189c = 5;
        } else if (i != 2) {
            this.f17189c = 4;
        } else {
            this.f17189c = 6;
        }
    }

    public fa0() {
        this.f17188b = 64;
        this.f17187a = new ArrayList();
    }
}
