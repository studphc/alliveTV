package com.google.android.gms.internal.measurement;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class zzah implements zzap {

    /* renamed from: a */
    public final Double f13781a;

    public zzah(Double d) {
        if (d == null) {
            this.f13781a = Double.valueOf(Double.NaN);
        } else {
            this.f13781a = d;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        return this.f13781a.equals(((zzah) obj).f13781a);
    }

    public final int hashCode() {
        return this.f13781a.hashCode();
    }

    public final String toString() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzcz(String str, zzg zzgVar, List list) {
        if ("toString".equals(str)) {
            return new zzat(zzi());
        }
        throw new IllegalArgumentException(zzi() + "." + str + " is not a function.");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzah(this.f13781a);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        Double d = this.f13781a;
        boolean z = false;
        if (!Double.isNaN(d.doubleValue()) && d.doubleValue() != 0.0d) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        return this.f13781a;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        BigDecimal stripTrailingZeros;
        int scale;
        Double d = this.f13781a;
        if (Double.isNaN(d.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(d.doubleValue())) {
            if (d.doubleValue() > 0.0d) {
                return "Infinity";
            }
            return "-Infinity";
        }
        BigDecimal valueOf = BigDecimal.valueOf(d.doubleValue());
        if (valueOf.signum() == 0) {
            stripTrailingZeros = new BigDecimal(BigInteger.ZERO, 0);
        } else if (valueOf.signum() == 0) {
            stripTrailingZeros = new BigDecimal(BigInteger.ZERO, 0);
        } else {
            stripTrailingZeros = valueOf.stripTrailingZeros();
        }
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (stripTrailingZeros.scale() > 0) {
            scale = stripTrailingZeros.precision();
        } else {
            scale = stripTrailingZeros.scale();
        }
        decimalFormat.setMinimumFractionDigits(scale - 1);
        String format = decimalFormat.format(stripTrailingZeros);
        int indexOf = format.indexOf(ExifInterface.LONGITUDE_EAST);
        if (indexOf > 0) {
            int parseInt = Integer.parseInt(format.substring(indexOf + 1));
            if ((parseInt < 0 && parseInt > -7) || (parseInt >= 0 && parseInt < 21)) {
                return stripTrailingZeros.toPlainString();
            }
            return format.replace("E-", "e-").replace(ExifInterface.LONGITUDE_EAST, "e+");
        }
        return format;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return null;
    }
}
