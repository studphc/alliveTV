package androidx.core.graphics;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class PathSegment {

    /* renamed from: a */
    public final PointF f3639a;

    /* renamed from: b */
    public final float f3640b;

    /* renamed from: c */
    public final PointF f3641c;

    /* renamed from: d */
    public final float f3642d;

    public PathSegment(@NonNull PointF pointF, float f, @NonNull PointF pointF2, float f2) {
        this.f3639a = (PointF) Preconditions.checkNotNull(pointF, "start == null");
        this.f3640b = f;
        this.f3641c = (PointF) Preconditions.checkNotNull(pointF2, "end == null");
        this.f3642d = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        if (Float.compare(this.f3640b, pathSegment.f3640b) == 0 && Float.compare(this.f3642d, pathSegment.f3642d) == 0 && this.f3639a.equals(pathSegment.f3639a) && this.f3641c.equals(pathSegment.f3641c)) {
            return true;
        }
        return false;
    }

    @NonNull
    public PointF getEnd() {
        return this.f3641c;
    }

    public float getEndFraction() {
        return this.f3642d;
    }

    @NonNull
    public PointF getStart() {
        return this.f3639a;
    }

    public float getStartFraction() {
        return this.f3640b;
    }

    public int hashCode() {
        int i;
        int hashCode = this.f3639a.hashCode() * 31;
        float f = this.f3640b;
        int i2 = 0;
        if (f != RecyclerView.f7068F0) {
            i = Float.floatToIntBits(f);
        } else {
            i = 0;
        }
        int hashCode2 = (this.f3641c.hashCode() + ((hashCode + i) * 31)) * 31;
        float f2 = this.f3642d;
        if (f2 != RecyclerView.f7068F0) {
            i2 = Float.floatToIntBits(f2);
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "PathSegment{start=" + this.f3639a + ", startFraction=" + this.f3640b + ", end=" + this.f3641c + ", endFraction=" + this.f3642d + '}';
    }
}
