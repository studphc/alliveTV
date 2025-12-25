package com.google.android.exoplayer2.source;

import java.util.Arrays;
import java.util.Random;

/* loaded from: classes.dex */
public interface ShuffleOrder {

    /* loaded from: classes.dex */
    public static class DefaultShuffleOrder implements ShuffleOrder {

        /* renamed from: a */
        public final Random f11047a;

        /* renamed from: b */
        public final int[] f11048b;

        /* renamed from: c */
        public final int[] f11049c;

        public DefaultShuffleOrder(int i) {
            this(i, new Random());
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndClear() {
            return new DefaultShuffleOrder(0, new Random(this.f11047a.nextLong()));
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndInsert(int i, int i2) {
            int[] iArr;
            Random random;
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            int i3 = 0;
            while (true) {
                iArr = this.f11048b;
                random = this.f11047a;
                if (i3 >= i2) {
                    break;
                }
                iArr2[i3] = random.nextInt(iArr.length + 1);
                int i4 = i3 + 1;
                int nextInt = random.nextInt(i4);
                iArr3[i3] = iArr3[nextInt];
                iArr3[nextInt] = i3 + i;
                i3 = i4;
            }
            Arrays.sort(iArr2);
            int[] iArr4 = new int[iArr.length + i2];
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < iArr.length + i2; i7++) {
                if (i5 < i2 && i6 == iArr2[i5]) {
                    iArr4[i7] = iArr3[i5];
                    i5++;
                } else {
                    int i8 = i6 + 1;
                    int i9 = iArr[i6];
                    iArr4[i7] = i9;
                    if (i9 >= i) {
                        iArr4[i7] = i9 + i2;
                    }
                    i6 = i8;
                }
            }
            return new DefaultShuffleOrder(iArr4, new Random(random.nextLong()));
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndRemove(int i, int i2) {
            int i3 = i2 - i;
            int[] iArr = this.f11048b;
            int[] iArr2 = new int[iArr.length - i3];
            int i4 = 0;
            for (int i5 = 0; i5 < iArr.length; i5++) {
                int i6 = iArr[i5];
                if (i6 >= i && i6 < i2) {
                    i4++;
                } else {
                    int i7 = i5 - i4;
                    if (i6 >= i) {
                        i6 -= i3;
                    }
                    iArr2[i7] = i6;
                }
            }
            return new DefaultShuffleOrder(iArr2, new Random(this.f11047a.nextLong()));
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            int[] iArr = this.f11048b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            int[] iArr = this.f11048b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.f11048b.length;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int i) {
            int i2 = this.f11049c[i] + 1;
            int[] iArr = this.f11048b;
            if (i2 < iArr.length) {
                return iArr[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int i) {
            int i2 = this.f11049c[i] - 1;
            if (i2 < 0) {
                return -1;
            }
            return this.f11048b[i2];
        }

        public DefaultShuffleOrder(int i, long j) {
            this(i, new Random(j));
        }

        public DefaultShuffleOrder(int[] iArr, long j) {
            this(Arrays.copyOf(iArr, iArr.length), new Random(j));
        }

        public DefaultShuffleOrder(int[] iArr, Random random) {
            this.f11048b = iArr;
            this.f11047a = random;
            this.f11049c = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.f11049c[iArr[i]] = i;
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DefaultShuffleOrder(int i, Random random) {
            this(r0, random);
            int[] iArr = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = i2 + 1;
                int nextInt = random.nextInt(i3);
                iArr[i2] = iArr[nextInt];
                iArr[nextInt] = i2;
                i2 = i3;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class UnshuffledShuffleOrder implements ShuffleOrder {

        /* renamed from: a */
        public final int f11050a;

        public UnshuffledShuffleOrder(int i) {
            this.f11050a = i;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndClear() {
            return new UnshuffledShuffleOrder(0);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndInsert(int i, int i2) {
            return new UnshuffledShuffleOrder(this.f11050a + i2);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public ShuffleOrder cloneAndRemove(int i, int i2) {
            return new UnshuffledShuffleOrder((this.f11050a - i2) + i);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            if (this.f11050a > 0) {
                return 0;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            int i = this.f11050a;
            if (i > 0) {
                return i - 1;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.f11050a;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int i) {
            int i2 = i + 1;
            if (i2 >= this.f11050a) {
                return -1;
            }
            return i2;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int i) {
            int i2 = i - 1;
            if (i2 >= 0) {
                return i2;
            }
            return -1;
        }
    }

    ShuffleOrder cloneAndClear();

    ShuffleOrder cloneAndInsert(int i, int i2);

    ShuffleOrder cloneAndRemove(int i, int i2);

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int i);

    int getPreviousIndex(int i);
}
