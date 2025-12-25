package androidx.core.view.accessibility;

import android.annotation.SuppressLint;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: classes.dex */
public class AccessibilityRecordCompat {

    /* renamed from: a */
    public final AccessibilityRecord f3966a;

    @Deprecated
    public AccessibilityRecordCompat(Object obj) {
        this.f3966a = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat accessibilityRecordCompat) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(accessibilityRecordCompat.f3966a));
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityRecordCompat)) {
            return false;
        }
        AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
        AccessibilityRecord accessibilityRecord = this.f3966a;
        if (accessibilityRecord == null) {
            if (accessibilityRecordCompat.f3966a == null) {
                return true;
            }
            return false;
        }
        return accessibilityRecord.equals(accessibilityRecordCompat.f3966a);
    }

    @Deprecated
    public int getAddedCount() {
        return this.f3966a.getAddedCount();
    }

    @Deprecated
    public CharSequence getBeforeText() {
        return this.f3966a.getBeforeText();
    }

    @Deprecated
    public CharSequence getClassName() {
        return this.f3966a.getClassName();
    }

    @Deprecated
    public CharSequence getContentDescription() {
        return this.f3966a.getContentDescription();
    }

    @Deprecated
    public int getCurrentItemIndex() {
        return this.f3966a.getCurrentItemIndex();
    }

    @Deprecated
    public int getFromIndex() {
        return this.f3966a.getFromIndex();
    }

    @Deprecated
    public Object getImpl() {
        return this.f3966a;
    }

    @Deprecated
    public int getItemCount() {
        return this.f3966a.getItemCount();
    }

    @Deprecated
    public int getMaxScrollX() {
        return getMaxScrollX(this.f3966a);
    }

    @Deprecated
    public int getMaxScrollY() {
        return getMaxScrollY(this.f3966a);
    }

    @Deprecated
    public Parcelable getParcelableData() {
        return this.f3966a.getParcelableData();
    }

    @Deprecated
    public int getRemovedCount() {
        return this.f3966a.getRemovedCount();
    }

    @Deprecated
    public int getScrollX() {
        return this.f3966a.getScrollX();
    }

    @Deprecated
    public int getScrollY() {
        return this.f3966a.getScrollY();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @Deprecated
    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.m922e(this.f3966a.getSource());
    }

    @Deprecated
    public List<CharSequence> getText() {
        return this.f3966a.getText();
    }

    @Deprecated
    public int getToIndex() {
        return this.f3966a.getToIndex();
    }

    @Deprecated
    public int getWindowId() {
        return this.f3966a.getWindowId();
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f3966a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public boolean isChecked() {
        return this.f3966a.isChecked();
    }

    @Deprecated
    public boolean isEnabled() {
        return this.f3966a.isEnabled();
    }

    @Deprecated
    public boolean isFullScreen() {
        return this.f3966a.isFullScreen();
    }

    @Deprecated
    public boolean isPassword() {
        return this.f3966a.isPassword();
    }

    @Deprecated
    public boolean isScrollable() {
        return this.f3966a.isScrollable();
    }

    @Deprecated
    public void recycle() {
        this.f3966a.recycle();
    }

    @Deprecated
    public void setAddedCount(int i) {
        this.f3966a.setAddedCount(i);
    }

    @Deprecated
    public void setBeforeText(CharSequence charSequence) {
        this.f3966a.setBeforeText(charSequence);
    }

    @Deprecated
    public void setChecked(boolean z) {
        this.f3966a.setChecked(z);
    }

    @Deprecated
    public void setClassName(CharSequence charSequence) {
        this.f3966a.setClassName(charSequence);
    }

    @Deprecated
    public void setContentDescription(CharSequence charSequence) {
        this.f3966a.setContentDescription(charSequence);
    }

    @Deprecated
    public void setCurrentItemIndex(int i) {
        this.f3966a.setCurrentItemIndex(i);
    }

    @Deprecated
    public void setEnabled(boolean z) {
        this.f3966a.setEnabled(z);
    }

    @Deprecated
    public void setFromIndex(int i) {
        this.f3966a.setFromIndex(i);
    }

    @Deprecated
    public void setFullScreen(boolean z) {
        this.f3966a.setFullScreen(z);
    }

    @Deprecated
    public void setItemCount(int i) {
        this.f3966a.setItemCount(i);
    }

    @Deprecated
    public void setMaxScrollX(int i) {
        setMaxScrollX(this.f3966a, i);
    }

    @Deprecated
    public void setMaxScrollY(int i) {
        setMaxScrollY(this.f3966a, i);
    }

    @Deprecated
    public void setParcelableData(Parcelable parcelable) {
        this.f3966a.setParcelableData(parcelable);
    }

    @Deprecated
    public void setPassword(boolean z) {
        this.f3966a.setPassword(z);
    }

    @Deprecated
    public void setRemovedCount(int i) {
        this.f3966a.setRemovedCount(i);
    }

    @Deprecated
    public void setScrollX(int i) {
        this.f3966a.setScrollX(i);
    }

    @Deprecated
    public void setScrollY(int i) {
        this.f3966a.setScrollY(i);
    }

    @Deprecated
    public void setScrollable(boolean z) {
        this.f3966a.setScrollable(z);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @Deprecated
    public void setSource(View view) {
        this.f3966a.setSource(view);
    }

    @Deprecated
    public void setToIndex(int i) {
        this.f3966a.setToIndex(i);
    }

    public static int getMaxScrollX(@NonNull AccessibilityRecord accessibilityRecord) {
        return accessibilityRecord.getMaxScrollX();
    }

    public static int getMaxScrollY(@NonNull AccessibilityRecord accessibilityRecord) {
        return accessibilityRecord.getMaxScrollY();
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    public static void setMaxScrollX(@NonNull AccessibilityRecord accessibilityRecord, int i) {
        accessibilityRecord.setMaxScrollX(i);
    }

    public static void setMaxScrollY(@NonNull AccessibilityRecord accessibilityRecord, int i) {
        accessibilityRecord.setMaxScrollY(i);
    }

    @Deprecated
    public void setSource(View view, int i) {
        setSource(this.f3966a, view, i);
    }

    public static void setSource(@NonNull AccessibilityRecord accessibilityRecord, @Nullable View view, int i) {
        accessibilityRecord.setSource(view, i);
    }
}
