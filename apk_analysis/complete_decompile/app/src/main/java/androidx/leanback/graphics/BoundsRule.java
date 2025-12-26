package androidx.leanback.graphics;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class BoundsRule {

    @Nullable
    public ValueRule bottom;

    @Nullable
    public ValueRule left;

    @Nullable
    public ValueRule right;

    @Nullable
    public ValueRule top;

    public BoundsRule() {
    }

    /* renamed from: a */
    public static int m1355a(int i, ValueRule valueRule, int i2) {
        return i + valueRule.f5355b + ((int) (valueRule.f5354a * i2));
    }

    public void calculateBounds(@NonNull Rect rect, @NonNull Rect rect2) {
        ValueRule valueRule = this.left;
        if (valueRule == null) {
            rect2.left = rect.left;
        } else {
            rect2.left = m1355a(rect.left, valueRule, rect.width());
        }
        ValueRule valueRule2 = this.right;
        if (valueRule2 == null) {
            rect2.right = rect.right;
        } else {
            rect2.right = m1355a(rect.left, valueRule2, rect.width());
        }
        ValueRule valueRule3 = this.top;
        if (valueRule3 == null) {
            rect2.top = rect.top;
        } else {
            rect2.top = m1355a(rect.top, valueRule3, rect.height());
        }
        ValueRule valueRule4 = this.bottom;
        if (valueRule4 == null) {
            rect2.bottom = rect.bottom;
        } else {
            rect2.bottom = m1355a(rect.top, valueRule4, rect.height());
        }
    }

    public BoundsRule(@NonNull BoundsRule boundsRule) {
        ValueRule valueRule = boundsRule.left;
        this.left = valueRule != null ? new ValueRule(valueRule) : null;
        ValueRule valueRule2 = boundsRule.right;
        this.right = valueRule2 != null ? new ValueRule(valueRule2) : null;
        ValueRule valueRule3 = boundsRule.top;
        this.top = valueRule3 != null ? new ValueRule(valueRule3) : null;
        ValueRule valueRule4 = boundsRule.bottom;
        this.bottom = valueRule4 != null ? new ValueRule(valueRule4) : null;
    }

    /* loaded from: classes.dex */
    public static final class ValueRule {

        /* renamed from: a */
        public float f5354a;

        /* renamed from: b */
        public int f5355b;

        public ValueRule(int i, float f) {
            this.f5355b = i;
            this.f5354a = f;
        }

        @NonNull
        public static ValueRule absoluteValue(int i) {
            return new ValueRule(i, RecyclerView.f7068F0);
        }

        @NonNull
        public static ValueRule inheritFromParent(float f) {
            return new ValueRule(0, f);
        }

        @NonNull
        public static ValueRule inheritFromParentWithOffset(float f, int i) {
            return new ValueRule(i, f);
        }

        public int getAbsoluteValue() {
            return this.f5355b;
        }

        public float getFraction() {
            return this.f5354a;
        }

        public void setAbsoluteValue(int i) {
            this.f5355b = i;
        }

        public void setFraction(float f) {
            this.f5354a = f;
        }

        public ValueRule(ValueRule valueRule) {
            this.f5354a = valueRule.f5354a;
            this.f5355b = valueRule.f5355b;
        }
    }
}
