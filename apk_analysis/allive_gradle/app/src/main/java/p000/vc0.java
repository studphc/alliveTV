package p000;

import java.io.File;
import java.util.ArrayDeque;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.AbstractIterator;
import kotlin.io.FileTreeWalk;
import kotlin.io.FileTreeWalk$FileTreeWalkIterator$WhenMappings;
import kotlin.io.FileWalkDirection;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class vc0 extends AbstractIterator {

    /* renamed from: c */
    public final ArrayDeque f27737c;

    /* renamed from: d */
    public final /* synthetic */ FileTreeWalk f27738d;

    public vc0(FileTreeWalk fileTreeWalk) {
        File file;
        File file2;
        File rootFile;
        File file3;
        this.f27738d = fileTreeWalk;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f27737c = arrayDeque;
        file = fileTreeWalk.f21112a;
        if (file.isDirectory()) {
            file3 = fileTreeWalk.f21112a;
            arrayDeque.push(m7903a(file3));
            return;
        }
        file2 = fileTreeWalk.f21112a;
        if (file2.isFile()) {
            rootFile = fileTreeWalk.f21112a;
            Intrinsics.checkNotNullParameter(rootFile, "rootFile");
            arrayDeque.push(new wc0(rootFile));
            return;
        }
        done();
    }

    /* renamed from: a */
    public final rc0 m7903a(File file) {
        FileWalkDirection fileWalkDirection;
        fileWalkDirection = this.f27738d.f21113b;
        int i = FileTreeWalk$FileTreeWalkIterator$WhenMappings.$EnumSwitchMapping$0[fileWalkDirection.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return new sc0(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }
        return new uc0(this, file);
    }

    @Override // kotlin.collections.AbstractIterator
    public final void computeNext() {
        File file;
        File mo7356a;
        int i;
        while (true) {
            ArrayDeque arrayDeque = this.f27737c;
            wc0 wc0Var = (wc0) arrayDeque.peek();
            if (wc0Var == null) {
                file = null;
                break;
            }
            mo7356a = wc0Var.mo7356a();
            if (mo7356a == null) {
                arrayDeque.pop();
            } else {
                if (Intrinsics.areEqual(mo7356a, wc0Var.f28136a) || !mo7356a.isDirectory()) {
                    break;
                }
                int size = arrayDeque.size();
                i = this.f27738d.f21117f;
                if (size >= i) {
                    break;
                } else {
                    arrayDeque.push(m7903a(mo7356a));
                }
            }
        }
        file = mo7356a;
        if (file != null) {
            setNext(file);
        } else {
            done();
        }
    }
}
