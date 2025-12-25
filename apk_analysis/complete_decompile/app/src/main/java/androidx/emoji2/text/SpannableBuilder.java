package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.text.SpannableStringBuilder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import p000.vl2;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class SpannableBuilder extends SpannableStringBuilder {

    /* renamed from: a */
    public final Class f4222a;

    /* renamed from: b */
    public final ArrayList f4223b;

    public SpannableBuilder(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f4223b = new ArrayList();
        Preconditions.checkNotNull(cls, "watcherClass cannot be null");
        this.f4222a = cls;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static SpannableBuilder create(@NonNull Class<?> cls, @NonNull CharSequence charSequence) {
        return new SpannableBuilder(cls, charSequence);
    }

    /* renamed from: a */
    public final void m1061a() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f4223b;
            if (i < arrayList.size()) {
                ((vl2) arrayList.get(i)).f27864b.incrementAndGet();
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public final vl2 m1062b(Object obj) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f4223b;
            if (i < arrayList.size()) {
                vl2 vl2Var = (vl2) arrayList.get(i);
                if (vl2Var.f27863a == obj) {
                    return vl2Var;
                }
                i++;
            } else {
                return null;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void beginBatchEdit() {
        m1061a();
    }

    /* renamed from: c */
    public final boolean m1063c(Object obj) {
        if (obj != null) {
            if (this.f4222a == obj.getClass()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public final void m1064d() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f4223b;
            if (i < arrayList.size()) {
                ((vl2) arrayList.get(i)).f27864b.decrementAndGet();
                i++;
            } else {
                return;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void endBatchEdit() {
        m1064d();
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f4223b;
            if (i < arrayList.size()) {
                ((vl2) arrayList.get(i)).onTextChanged(this, 0, length(), length());
                i++;
            } else {
                return;
            }
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(@Nullable Object obj) {
        vl2 m1062b;
        if (m1063c(obj) && (m1062b = m1062b(obj)) != null) {
            obj = m1062b;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(@Nullable Object obj) {
        vl2 m1062b;
        if (m1063c(obj) && (m1062b = m1062b(obj)) != null) {
            obj = m1062b;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(@Nullable Object obj) {
        vl2 m1062b;
        if (m1063c(obj) && (m1062b = m1062b(obj)) != null) {
            obj = m1062b;
        }
        return super.getSpanStart(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    @SuppressLint({"UnknownNullness"})
    public <T> T[] getSpans(int i, int i2, @NonNull Class<T> cls) {
        if (this.f4222a == cls) {
            vl2[] vl2VarArr = (vl2[]) super.getSpans(i, i2, vl2.class);
            T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, vl2VarArr.length));
            for (int i3 = 0; i3 < vl2VarArr.length; i3++) {
                tArr[i3] = vl2VarArr[i3].f27863a;
            }
            return tArr;
        }
        return (T[]) super.getSpans(i, i2, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i, int i2, @Nullable Class cls) {
        if (cls == null || this.f4222a == cls) {
            cls = vl2.class;
        }
        return super.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(@Nullable Object obj) {
        vl2 vl2Var;
        if (m1063c(obj)) {
            vl2Var = m1062b(obj);
            if (vl2Var != null) {
                obj = vl2Var;
            }
        } else {
            vl2Var = null;
        }
        super.removeSpan(obj);
        if (vl2Var != null) {
            this.f4223b.remove(vl2Var);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(@Nullable Object obj, int i, int i2, int i3) {
        if (m1063c(obj)) {
            vl2 vl2Var = new vl2(obj);
            this.f4223b.add(vl2Var);
            obj = vl2Var;
        }
        super.setSpan(obj, i, i2, i3);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    @SuppressLint({"UnknownNullness"})
    public CharSequence subSequence(int i, int i2) {
        return new SpannableBuilder(this.f4222a, this, i, i2);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder delete(int i, int i2) {
        super.delete(i, i2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence) {
        m1061a();
        super.replace(i, i2, charSequence);
        m1064d();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i, CharSequence charSequence, int i2, int i3) {
        super.insert(i, charSequence, i2, i3);
        return this;
    }

    public SpannableBuilder(Class cls, SpannableBuilder spannableBuilder, int i, int i2) {
        super(spannableBuilder, i, i2);
        this.f4223b = new ArrayList();
        Preconditions.checkNotNull(cls, "watcherClass cannot be null");
        this.f4222a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        m1061a();
        super.replace(i, i2, charSequence, i3, i4);
        m1064d();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public SpannableStringBuilder append(char c) {
        super.append(c);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i, int i2) {
        super.append(charSequence, i, i2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i) {
        super.append(charSequence, obj, i);
        return this;
    }
}
