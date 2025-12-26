package kotlin.io;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import p000.n81;

@Metadata(m5568d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m5569d2 = {"kotlin/io/LinesSequence$iterator$1", "", "", "", "hasNext", "()Z", "next", "()Ljava/lang/String;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class LinesSequence$iterator$1 implements Iterator<String>, KMappedMarker {

    /* renamed from: a */
    public String f21126a;

    /* renamed from: b */
    public boolean f21127b;

    /* renamed from: c */
    public final /* synthetic */ n81 f21128c;

    public LinesSequence$iterator$1(n81 n81Var) {
        this.f21128c = n81Var;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f21126a == null && !this.f21127b) {
            String readLine = this.f21128c.f23284a.readLine();
            this.f21126a = readLine;
            if (readLine == null) {
                this.f21127b = true;
            }
        }
        if (this.f21126a != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    @NotNull
    public String next() {
        if (hasNext()) {
            String str = this.f21126a;
            this.f21126a = null;
            Intrinsics.checkNotNull(str);
            return str;
        }
        throw new NoSuchElementException();
    }
}
