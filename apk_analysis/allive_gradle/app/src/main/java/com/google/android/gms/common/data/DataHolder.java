package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.sqlite.CursorWrapper;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@KeepForSdk
@KeepName
@SafeParcelable.Class(creator = "DataHolderCreator", validate = true)
/* loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<DataHolder> CREATOR = new zaf();

    /* renamed from: k */
    public static final C0751a f13324k = new Builder(new String[0]);

    /* renamed from: a */
    public final int f13325a;

    /* renamed from: b */
    public final String[] f13326b;

    /* renamed from: c */
    public Bundle f13327c;

    /* renamed from: d */
    public final CursorWindow[] f13328d;

    /* renamed from: e */
    public final int f13329e;

    /* renamed from: f */
    public final Bundle f13330f;

    /* renamed from: g */
    public int[] f13331g;

    /* renamed from: h */
    public int f13332h;

    /* renamed from: i */
    public boolean f13333i;

    /* renamed from: j */
    public final boolean f13334j;

    public DataHolder(Builder builder, int i) {
        this(builder.f13335a, m3130b(builder), i, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0123, code lost:
    
        if (r6 != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0125, code lost:
    
        android.util.Log.d("DataHolder", "Couldn't populate window data for row " + r5 + " - allocating new window.");
        r3.freeLastRow();
        r3 = new android.database.CursorWindow(false);
        r3.setStartPosition(r5);
        r3.setNumColumns(r14.length);
        r4.add(r3);
        r5 = r5 - 1;
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x015d, code lost:
    
        throw new com.google.android.gms.common.data.zad("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CursorWindow[] m3130b(Builder builder) {
        long j;
        if (builder.f13335a.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList arrayList = builder.f13336b;
        int size = arrayList.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(cursorWindow);
        String[] strArr = builder.f13335a;
        cursorWindow.setNumColumns(strArr.length);
        int i = 0;
        boolean z = false;
        while (i < size) {
            try {
                if (!cursorWindow.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i + ")");
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i);
                    cursorWindow.setNumColumns(strArr.length);
                    arrayList2.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList2.remove(cursorWindow);
                        return (CursorWindow[]) arrayList2.toArray(new CursorWindow[arrayList2.size()]);
                    }
                }
                Map map = (Map) arrayList.get(i);
                int i2 = 0;
                boolean z2 = true;
                while (true) {
                    if (i2 < strArr.length) {
                        if (!z2) {
                            break;
                        }
                        String str = strArr[i2];
                        Object obj = map.get(str);
                        if (obj == null) {
                            z2 = cursorWindow.putNull(i, i2);
                        } else if (obj instanceof String) {
                            z2 = cursorWindow.putString((String) obj, i, i2);
                        } else if (obj instanceof Long) {
                            z2 = cursorWindow.putLong(((Long) obj).longValue(), i, i2);
                        } else if (obj instanceof Integer) {
                            z2 = cursorWindow.putLong(((Integer) obj).intValue(), i, i2);
                        } else if (obj instanceof Boolean) {
                            if (true != ((Boolean) obj).booleanValue()) {
                                j = 0;
                            } else {
                                j = 1;
                            }
                            z2 = cursorWindow.putLong(j, i, i2);
                        } else if (obj instanceof byte[]) {
                            z2 = cursorWindow.putBlob((byte[]) obj, i, i2);
                        } else if (obj instanceof Double) {
                            z2 = cursorWindow.putDouble(((Double) obj).doubleValue(), i, i2);
                        } else if (obj instanceof Float) {
                            z2 = cursorWindow.putDouble(((Float) obj).floatValue(), i, i2);
                        } else {
                            throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj.toString());
                        }
                        i2++;
                    } else if (z2) {
                        z = false;
                    }
                }
                i++;
            } catch (RuntimeException e) {
                int size2 = arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ((CursorWindow) arrayList2.get(i3)).close();
                }
                throw e;
            }
        }
        return (CursorWindow[]) arrayList2.toArray(new CursorWindow[arrayList2.size()]);
    }

    @NonNull
    @KeepForSdk
    public static Builder builder(@NonNull String[] strArr) {
        return new Builder(strArr);
    }

    @NonNull
    @KeepForSdk
    public static DataHolder empty(int i) {
        return new DataHolder(f13324k, i);
    }

    /* renamed from: a */
    public final void m3131a(int i, String str) {
        Bundle bundle = this.f13327c;
        if (bundle != null && bundle.containsKey(str)) {
            if (!isClosed()) {
                if (i >= 0 && i < this.f13332h) {
                    return;
                } else {
                    throw new CursorIndexOutOfBoundsException(i, this.f13332h);
                }
            }
            throw new IllegalArgumentException("Buffer is closed.");
        }
        throw new IllegalArgumentException("No such column: ".concat(String.valueOf(str)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @KeepForSdk
    public void close() {
        synchronized (this) {
            try {
                if (!this.f13333i) {
                    this.f13333i = true;
                    int i = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.f13328d;
                        if (i >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i].close();
                        i++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void finalize() {
        try {
            if (this.f13334j && this.f13328d.length > 0 && !isClosed()) {
                close();
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: " + toString() + ")");
            }
        } finally {
            super.finalize();
        }
    }

    @KeepForSdk
    public boolean getBoolean(@NonNull String str, int i, int i2) {
        m3131a(i, str);
        if (this.f13328d[i2].getLong(i, this.f13327c.getInt(str)) == 1) {
            return true;
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public byte[] getByteArray(@NonNull String str, int i, int i2) {
        m3131a(i, str);
        return this.f13328d[i2].getBlob(i, this.f13327c.getInt(str));
    }

    @KeepForSdk
    public int getCount() {
        return this.f13332h;
    }

    @KeepForSdk
    public int getInteger(@NonNull String str, int i, int i2) {
        m3131a(i, str);
        return this.f13328d[i2].getInt(i, this.f13327c.getInt(str));
    }

    @KeepForSdk
    public long getLong(@NonNull String str, int i, int i2) {
        m3131a(i, str);
        return this.f13328d[i2].getLong(i, this.f13327c.getInt(str));
    }

    @Nullable
    @KeepForSdk
    public Bundle getMetadata() {
        return this.f13330f;
    }

    @KeepForSdk
    public int getStatusCode() {
        return this.f13329e;
    }

    @NonNull
    @KeepForSdk
    public String getString(@NonNull String str, int i, int i2) {
        m3131a(i, str);
        return this.f13328d[i2].getString(i, this.f13327c.getInt(str));
    }

    @KeepForSdk
    public int getWindowIndex(int i) {
        boolean z;
        int length;
        int i2 = 0;
        if (i >= 0 && i < this.f13332h) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        while (true) {
            int[] iArr = this.f13331g;
            length = iArr.length;
            if (i2 >= length) {
                break;
            }
            if (i < iArr[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        if (i2 == length) {
            return i2 - 1;
        }
        return i2;
    }

    @KeepForSdk
    public boolean hasColumn(@NonNull String str) {
        return this.f13327c.containsKey(str);
    }

    @KeepForSdk
    public boolean hasNull(@NonNull String str, int i, int i2) {
        m3131a(i, str);
        return this.f13328d[i2].isNull(i, this.f13327c.getInt(str));
    }

    @KeepForSdk
    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.f13333i;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.f13326b, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.f13328d, i, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f13325a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i & 1) != 0) {
            close();
        }
    }

    public final double zaa(@NonNull String str, int i, int i2) {
        m3131a(i, str);
        return this.f13328d[i2].getDouble(i, this.f13327c.getInt(str));
    }

    public final float zab(@NonNull String str, int i, int i2) {
        m3131a(i, str);
        return this.f13328d[i2].getFloat(i, this.f13327c.getInt(str));
    }

    public final void zac(@NonNull String str, int i, int i2, @NonNull CharArrayBuffer charArrayBuffer) {
        m3131a(i, str);
        this.f13328d[i2].copyStringToBuffer(i, this.f13327c.getInt(str), charArrayBuffer);
    }

    public final void zad() {
        this.f13327c = new Bundle();
        int i = 0;
        while (true) {
            String[] strArr = this.f13326b;
            if (i >= strArr.length) {
                break;
            }
            this.f13327c.putInt(strArr[i], i);
            i++;
        }
        CursorWindow[] cursorWindowArr = this.f13328d;
        this.f13331g = new int[cursorWindowArr.length];
        int i2 = 0;
        for (int i3 = 0; i3 < cursorWindowArr.length; i3++) {
            this.f13331g[i3] = i2;
            i2 += cursorWindowArr[i3].getNumRows() - (i2 - cursorWindowArr[i3].getStartPosition());
        }
        this.f13332h = i2;
    }

    @KeepForSdk
    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public final String[] f13335a;

        /* renamed from: b */
        public final ArrayList f13336b = new ArrayList();

        public /* synthetic */ Builder(String[] strArr) {
            this.f13335a = (String[]) Preconditions.checkNotNull(strArr);
            new HashMap();
        }

        @NonNull
        @KeepForSdk
        public DataHolder build(int i) {
            return new DataHolder(this, i);
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public Builder withRow(@NonNull ContentValues contentValues) {
            Asserts.checkNotNull(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return zaa(hashMap);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder zaa(@NonNull HashMap hashMap) {
            Asserts.checkNotNull(hashMap);
            this.f13336b.add(hashMap);
            return this;
        }

        @NonNull
        @KeepForSdk
        public DataHolder build(int i, @NonNull Bundle bundle) {
            return new DataHolder(this.f13335a, DataHolder.m3130b(this), i, bundle);
        }
    }

    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.f13333i = false;
        this.f13334j = true;
        this.f13325a = i;
        this.f13326b = strArr;
        this.f13328d = cursorWindowArr;
        this.f13329e = i2;
        this.f13330f = bundle;
    }

    @KeepForSdk
    public DataHolder(@NonNull String[] strArr, @NonNull CursorWindow[] cursorWindowArr, int i, @Nullable Bundle bundle) {
        this.f13333i = false;
        this.f13334j = true;
        this.f13325a = 1;
        this.f13326b = (String[]) Preconditions.checkNotNull(strArr);
        this.f13328d = (CursorWindow[]) Preconditions.checkNotNull(cursorWindowArr);
        this.f13329e = i;
        this.f13330f = bundle;
        zad();
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DataHolder(@NonNull Cursor cursor, int i, @Nullable Bundle bundle) {
        this(r8, (CursorWindow[]) r1.toArray(new CursorWindow[r1.size()]), i, bundle);
        int i2;
        CursorWrapper cursorWrapper = new CursorWrapper(cursor);
        String[] columnNames = cursorWrapper.getColumnNames();
        ArrayList arrayList = new ArrayList();
        try {
            int count = cursorWrapper.getCount();
            CursorWindow window = cursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i2 = 0;
            } else {
                window.acquireReference();
                cursorWrapper.setWindow(null);
                arrayList.add(window);
                i2 = window.getNumRows();
            }
            while (i2 < count) {
                if (!cursorWrapper.moveToPosition(i2)) {
                    break;
                }
                CursorWindow window2 = cursorWrapper.getWindow();
                if (window2 != null) {
                    window2.acquireReference();
                    cursorWrapper.setWindow(null);
                } else {
                    window2 = new CursorWindow(false);
                    window2.setStartPosition(i2);
                    cursorWrapper.fillWindow(i2, window2);
                }
                if (window2.getNumRows() == 0) {
                    break;
                }
                arrayList.add(window2);
                i2 = window2.getStartPosition() + window2.getNumRows();
            }
            cursorWrapper.close();
        } catch (Throwable th) {
            cursorWrapper.close();
            throw th;
        }
    }
}
