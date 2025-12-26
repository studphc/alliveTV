package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import p000.a40;
import p000.b40;
import p000.x30;
import p000.y30;
import p000.ye0;
import p000.z30;

/* loaded from: classes.dex */
public class DiffUtil {

    /* renamed from: a */
    public static final x30 f6975a = new x30(0);

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        @Nullable
        public Object getChangePayload(int i, int i2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* loaded from: classes.dex */
    public static class DiffResult {
        public static final int NO_POSITION = -1;

        /* renamed from: a */
        public final ArrayList f6976a;

        /* renamed from: b */
        public final int[] f6977b;

        /* renamed from: c */
        public final int[] f6978c;

        /* renamed from: d */
        public final Callback f6979d;

        /* renamed from: e */
        public final int f6980e;

        /* renamed from: f */
        public final int f6981f;

        /* renamed from: g */
        public final boolean f6982g;

        public DiffResult(Callback callback, ArrayList arrayList, int[] iArr, int[] iArr2, boolean z) {
            y30 y30Var;
            int[] iArr3;
            int[] iArr4;
            Callback callback2;
            int i;
            y30 y30Var2;
            int i2;
            int i3;
            int i4;
            this.f6976a = arrayList;
            this.f6977b = iArr;
            this.f6978c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f6979d = callback;
            int oldListSize = callback.getOldListSize();
            this.f6980e = oldListSize;
            int newListSize = callback.getNewListSize();
            this.f6981f = newListSize;
            this.f6982g = z;
            if (arrayList.isEmpty()) {
                y30Var = null;
            } else {
                y30Var = (y30) arrayList.get(0);
            }
            if (y30Var == null || y30Var.f28817a != 0 || y30Var.f28818b != 0) {
                arrayList.add(0, new y30(0, 0, 0));
            }
            arrayList.add(new y30(oldListSize, newListSize, 0));
            Iterator it = arrayList.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                iArr3 = this.f6978c;
                iArr4 = this.f6977b;
                callback2 = this.f6979d;
                if (!hasNext) {
                    break;
                }
                y30 y30Var3 = (y30) it.next();
                for (int i5 = 0; i5 < y30Var3.f28819c; i5++) {
                    int i6 = y30Var3.f28817a + i5;
                    int i7 = y30Var3.f28818b + i5;
                    if (callback2.areContentsTheSame(i6, i7)) {
                        i4 = 1;
                    } else {
                        i4 = 2;
                    }
                    iArr4[i6] = (i7 << 4) | i4;
                    iArr3[i7] = (i6 << 4) | i4;
                }
            }
            if (this.f6982g) {
                Iterator it2 = arrayList.iterator();
                int i8 = 0;
                while (it2.hasNext()) {
                    y30 y30Var4 = (y30) it2.next();
                    while (true) {
                        i = y30Var4.f28817a;
                        if (i8 < i) {
                            if (iArr4[i8] == 0) {
                                int size = arrayList.size();
                                int i9 = 0;
                                int i10 = 0;
                                while (true) {
                                    if (i9 < size) {
                                        y30Var2 = (y30) arrayList.get(i9);
                                        while (true) {
                                            i2 = y30Var2.f28818b;
                                            if (i10 < i2) {
                                                if (iArr3[i10] == 0 && callback2.areItemsTheSame(i8, i10)) {
                                                    if (callback2.areContentsTheSame(i8, i10)) {
                                                        i3 = 8;
                                                    } else {
                                                        i3 = 4;
                                                    }
                                                    iArr4[i8] = (i10 << 4) | i3;
                                                    iArr3[i10] = i3 | (i8 << 4);
                                                } else {
                                                    i10++;
                                                }
                                            }
                                        }
                                    }
                                    i10 = y30Var2.f28819c + i2;
                                    i9++;
                                }
                            }
                            i8++;
                        }
                    }
                    i8 = y30Var4.f28819c + i;
                }
            }
        }

        /* renamed from: a */
        public static z30 m1612a(ArrayDeque arrayDeque, int i, boolean z) {
            z30 z30Var;
            Iterator it = arrayDeque.iterator();
            while (true) {
                if (it.hasNext()) {
                    z30Var = (z30) it.next();
                    if (z30Var.f29231a == i && z30Var.f29233c == z) {
                        it.remove();
                        break;
                    }
                } else {
                    z30Var = null;
                    break;
                }
            }
            while (it.hasNext()) {
                z30 z30Var2 = (z30) it.next();
                if (z) {
                    z30Var2.f29232b--;
                } else {
                    z30Var2.f29232b++;
                }
            }
            return z30Var;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i) {
            int i2 = this.f6981f;
            if (i >= 0 && i < i2) {
                int i3 = this.f6978c[i];
                if ((i3 & 15) == 0) {
                    return -1;
                }
                return i3 >> 4;
            }
            throw new IndexOutOfBoundsException(ye0.m8293m(i, "Index out of bounds - passed position = ", ", new list size = ", i2));
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i) {
            int i2 = this.f6980e;
            if (i >= 0 && i < i2) {
                int i3 = this.f6977b[i];
                if ((i3 & 15) == 0) {
                    return -1;
                }
                return i3 >> 4;
            }
            throw new IndexOutOfBoundsException(ye0.m8293m(i, "Index out of bounds - passed position = ", ", old list size = ", i2));
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            int[] iArr;
            Callback callback;
            int i;
            int i2;
            ArrayList arrayList;
            int i3;
            DiffResult diffResult = this;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            ArrayList arrayList2 = diffResult.f6976a;
            int size = arrayList2.size() - 1;
            int i4 = diffResult.f6980e;
            int i5 = diffResult.f6981f;
            int i6 = i4;
            while (size >= 0) {
                y30 y30Var = (y30) arrayList2.get(size);
                int i7 = y30Var.f28817a;
                int i8 = y30Var.f28819c;
                int i9 = i7 + i8;
                int i10 = y30Var.f28818b;
                int i11 = i10 + i8;
                while (true) {
                    iArr = diffResult.f6977b;
                    callback = diffResult.f6979d;
                    i = 0;
                    if (i6 <= i9) {
                        break;
                    }
                    i6--;
                    int i12 = iArr[i6];
                    if ((i12 & 12) != 0) {
                        arrayList = arrayList2;
                        int i13 = i12 >> 4;
                        z30 m1612a = m1612a(arrayDeque, i13, false);
                        if (m1612a != null) {
                            i3 = i5;
                            int i14 = (i4 - m1612a.f29232b) - 1;
                            batchingListUpdateCallback.onMoved(i6, i14);
                            if ((i12 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i14, 1, callback.getChangePayload(i6, i13));
                            }
                        } else {
                            i3 = i5;
                            arrayDeque.add(new z30(i6, (i4 - i6) - 1, true));
                        }
                    } else {
                        arrayList = arrayList2;
                        i3 = i5;
                        batchingListUpdateCallback.onRemoved(i6, 1);
                        i4--;
                    }
                    arrayList2 = arrayList;
                    i5 = i3;
                }
                ArrayList arrayList3 = arrayList2;
                while (i5 > i11) {
                    i5--;
                    int i15 = diffResult.f6978c[i5];
                    if ((i15 & 12) != 0) {
                        int i16 = i15 >> 4;
                        z30 m1612a2 = m1612a(arrayDeque, i16, true);
                        if (m1612a2 == null) {
                            arrayDeque.add(new z30(i5, i4 - i6, false));
                            i2 = 0;
                        } else {
                            i2 = 0;
                            batchingListUpdateCallback.onMoved((i4 - m1612a2.f29232b) - 1, i6);
                            if ((i15 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i6, 1, callback.getChangePayload(i16, i5));
                            }
                        }
                    } else {
                        i2 = i;
                        batchingListUpdateCallback.onInserted(i6, 1);
                        i4++;
                    }
                    diffResult = this;
                    i = i2;
                }
                i6 = y30Var.f28817a;
                int i17 = i6;
                int i18 = i10;
                while (i < i8) {
                    if ((iArr[i17] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i17, 1, callback.getChangePayload(i17, i18));
                    }
                    i17++;
                    i18++;
                    i++;
                }
                size--;
                diffResult = this;
                i5 = i10;
                arrayList2 = arrayList3;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t, @NonNull T t2);

        public abstract boolean areItemsTheSame(@NonNull T t, @NonNull T t2);

        @Nullable
        public Object getChangePayload(@NonNull T t, @NonNull T t2) {
            return null;
        }
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v43, types: [java.lang.Object, b40] */
    /* JADX WARN: Type inference failed for: r0v51, types: [java.lang.Object, b40] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, a40] */
    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        a40 a40Var;
        b40 b40Var;
        ArrayList arrayList3;
        ArrayList arrayList4;
        a40 a40Var2;
        a40 a40Var3;
        y30 y30Var;
        int i;
        int i2;
        b40 b40Var2;
        b40 b40Var3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ?? obj = new Object();
        int i9 = 0;
        obj.f33a = 0;
        obj.f34b = oldListSize;
        obj.f35c = 0;
        obj.f36d = newListSize;
        arrayList6.add(obj);
        int i10 = oldListSize + newListSize;
        int i11 = 1;
        int i12 = (((i10 + 1) / 2) * 2) + 1;
        int[] iArr = new int[i12];
        int i13 = i12 / 2;
        int[] iArr2 = new int[i12];
        ArrayList arrayList7 = new ArrayList();
        while (!arrayList6.isEmpty()) {
            a40 a40Var4 = (a40) arrayList6.remove(arrayList6.size() - i11);
            if (a40Var4.m14b() >= i11 && a40Var4.m13a() >= i11) {
                int m13a = ((a40Var4.m13a() + a40Var4.m14b()) + i11) / 2;
                int i14 = i11 + i13;
                iArr[i14] = a40Var4.f33a;
                iArr2[i14] = a40Var4.f34b;
                int i15 = i9;
                while (i15 < m13a) {
                    int i16 = Math.abs(a40Var4.m14b() - a40Var4.m13a()) % 2 == i11 ? i11 : i9;
                    int m14b = a40Var4.m14b() - a40Var4.m13a();
                    int i17 = -i15;
                    int i18 = i17;
                    while (true) {
                        if (i18 > i15) {
                            arrayList = arrayList7;
                            arrayList2 = arrayList6;
                            i = i9;
                            i2 = m13a;
                            b40Var2 = null;
                            break;
                        }
                        if (i18 != i17 && (i18 == i15 || iArr[i18 + 1 + i13] <= iArr[(i18 - 1) + i13])) {
                            i6 = iArr[(i18 - 1) + i13];
                            i7 = i6 + 1;
                        } else {
                            i6 = iArr[i18 + 1 + i13];
                            i7 = i6;
                        }
                        i2 = m13a;
                        arrayList2 = arrayList6;
                        int i19 = ((i7 - a40Var4.f33a) + a40Var4.f35c) - i18;
                        int i20 = (i15 == 0 || i7 != i6) ? i19 : i19 - 1;
                        arrayList = arrayList7;
                        while (i7 < a40Var4.f34b && i19 < a40Var4.f36d && callback.areItemsTheSame(i7, i19)) {
                            i7++;
                            i19++;
                        }
                        iArr[i18 + i13] = i7;
                        if (i16 != 0) {
                            int i21 = m14b - i18;
                            i8 = i16;
                            if (i21 >= i17 + 1 && i21 <= i15 - 1 && iArr2[i21 + i13] <= i7) {
                                ?? obj2 = new Object();
                                obj2.f7882a = i6;
                                obj2.f7883b = i20;
                                obj2.f7884c = i7;
                                obj2.f7885d = i19;
                                i = 0;
                                obj2.f7886e = false;
                                b40Var2 = obj2;
                                break;
                            }
                        } else {
                            i8 = i16;
                        }
                        i18 += 2;
                        i9 = 0;
                        m13a = i2;
                        arrayList6 = arrayList2;
                        arrayList7 = arrayList;
                        i16 = i8;
                    }
                    if (b40Var2 != null) {
                        b40Var = b40Var2;
                        a40Var = a40Var4;
                        break;
                    }
                    int i22 = (a40Var4.m14b() - a40Var4.m13a()) % 2 == 0 ? 1 : i;
                    int m14b2 = a40Var4.m14b() - a40Var4.m13a();
                    int i23 = i17;
                    while (true) {
                        if (i23 > i15) {
                            a40Var = a40Var4;
                            b40Var3 = null;
                            break;
                        }
                        if (i23 != i17 && (i23 == i15 || iArr2[i23 + 1 + i13] >= iArr2[(i23 - 1) + i13])) {
                            i3 = iArr2[(i23 - 1) + i13];
                            i4 = i3 - 1;
                        } else {
                            i3 = iArr2[i23 + 1 + i13];
                            i4 = i3;
                        }
                        int i24 = a40Var4.f36d - ((a40Var4.f34b - i4) - i23);
                        int i25 = (i15 == 0 || i4 != i3) ? i24 : i24 + 1;
                        while (i4 > a40Var4.f33a && i24 > a40Var4.f35c) {
                            a40Var = a40Var4;
                            if (!callback.areItemsTheSame(i4 - 1, i24 - 1)) {
                                break;
                            }
                            i4--;
                            i24--;
                            a40Var4 = a40Var;
                        }
                        a40Var = a40Var4;
                        iArr2[i23 + i13] = i4;
                        if (i22 != 0 && (i5 = m14b2 - i23) >= i17 && i5 <= i15 && iArr[i5 + i13] >= i4) {
                            ?? obj3 = new Object();
                            obj3.f7882a = i4;
                            obj3.f7883b = i24;
                            obj3.f7884c = i3;
                            obj3.f7885d = i25;
                            obj3.f7886e = true;
                            b40Var3 = obj3;
                            break;
                        }
                        i23 += 2;
                        a40Var4 = a40Var;
                    }
                    if (b40Var3 != null) {
                        b40Var = b40Var3;
                        break;
                    }
                    i15++;
                    m13a = i2;
                    arrayList6 = arrayList2;
                    arrayList7 = arrayList;
                    a40Var4 = a40Var;
                    i11 = 1;
                    i9 = 0;
                }
            }
            arrayList = arrayList7;
            arrayList2 = arrayList6;
            a40Var = a40Var4;
            b40Var = null;
            if (b40Var != null) {
                if (b40Var.m2016a() > 0) {
                    int i26 = b40Var.f7885d;
                    int i27 = b40Var.f7883b;
                    int i28 = i26 - i27;
                    int i29 = b40Var.f7884c;
                    int i30 = b40Var.f7882a;
                    int i31 = i29 - i30;
                    if (i28 != i31) {
                        if (b40Var.f7886e) {
                            y30Var = new y30(i30, i27, b40Var.m2016a());
                        } else if (i28 > i31) {
                            y30Var = new y30(i30, i27 + 1, b40Var.m2016a());
                        } else {
                            y30Var = new y30(i30 + 1, i27, b40Var.m2016a());
                        }
                    } else {
                        y30Var = new y30(i30, i27, i31);
                    }
                    arrayList5.add(y30Var);
                }
                if (arrayList.isEmpty()) {
                    arrayList4 = arrayList;
                    a40Var2 = a40Var;
                    i11 = 1;
                    a40Var3 = new Object();
                } else {
                    i11 = 1;
                    arrayList4 = arrayList;
                    a40Var2 = a40Var;
                    a40Var3 = (a40) arrayList4.remove(arrayList.size() - 1);
                }
                a40Var3.f33a = a40Var2.f33a;
                a40Var3.f35c = a40Var2.f35c;
                a40Var3.f34b = b40Var.f7882a;
                a40Var3.f36d = b40Var.f7883b;
                arrayList3 = arrayList2;
                arrayList3.add(a40Var3);
                a40Var2.f34b = a40Var2.f34b;
                a40Var2.f36d = a40Var2.f36d;
                a40Var2.f33a = b40Var.f7884c;
                a40Var2.f35c = b40Var.f7885d;
                arrayList3.add(a40Var2);
            } else {
                arrayList3 = arrayList2;
                arrayList4 = arrayList;
                i11 = 1;
                arrayList4.add(a40Var);
            }
            arrayList7 = arrayList4;
            arrayList6 = arrayList3;
            i9 = 0;
        }
        Collections.sort(arrayList5, f6975a);
        return new DiffResult(callback, arrayList5, iArr, iArr2, z);
    }
}
