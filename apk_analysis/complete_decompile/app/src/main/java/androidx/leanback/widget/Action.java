package androidx.leanback.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Action {
    public static final long NO_ID = -1;

    /* renamed from: a */
    public long f5557a;

    /* renamed from: b */
    public Drawable f5558b;

    /* renamed from: c */
    public CharSequence f5559c;

    /* renamed from: d */
    public CharSequence f5560d;

    /* renamed from: e */
    public final ArrayList f5561e;

    public Action(long j) {
        this(j, "");
    }

    public final void addKeyCode(int i) {
        this.f5561e.add(Integer.valueOf(i));
    }

    @Nullable
    public final Drawable getIcon() {
        return this.f5558b;
    }

    public final long getId() {
        return this.f5557a;
    }

    @Nullable
    public final CharSequence getLabel1() {
        return this.f5559c;
    }

    @Nullable
    public final CharSequence getLabel2() {
        return this.f5560d;
    }

    public final void removeKeyCode(int i) {
        this.f5561e.remove(i);
    }

    public final boolean respondsToKeyCode(int i) {
        return this.f5561e.contains(Integer.valueOf(i));
    }

    public final void setIcon(@Nullable Drawable drawable) {
        this.f5558b = drawable;
    }

    public final void setId(long j) {
        this.f5557a = j;
    }

    public final void setLabel1(@Nullable CharSequence charSequence) {
        this.f5559c = charSequence;
    }

    public final void setLabel2(@Nullable CharSequence charSequence) {
        this.f5560d = charSequence;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f5559c)) {
            sb.append(this.f5559c);
        }
        if (!TextUtils.isEmpty(this.f5560d)) {
            if (!TextUtils.isEmpty(this.f5559c)) {
                sb.append(" ");
            }
            sb.append(this.f5560d);
        }
        if (this.f5558b != null && sb.length() == 0) {
            sb.append("(action icon)");
        }
        return sb.toString();
    }

    public Action(long j, @Nullable CharSequence charSequence) {
        this(j, charSequence, null);
    }

    public Action(long j, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        this(j, charSequence, charSequence2, null);
    }

    public Action(long j, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable Drawable drawable) {
        this.f5557a = -1L;
        this.f5561e = new ArrayList();
        setId(j);
        setLabel1(charSequence);
        setLabel2(charSequence2);
        setIcon(drawable);
    }
}
