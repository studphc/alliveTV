package com.google.firebase.installations;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.time.Clock;
import com.google.firebase.installations.time.SystemClock;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class Utils {
    public static final long AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS = TimeUnit.HOURS.toSeconds(1);

    /* renamed from: b */
    public static final Pattern f15584b = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* renamed from: c */
    public static Utils f15585c;

    /* renamed from: a */
    public final Clock f15586a;

    public Utils(Clock clock) {
        this.f15586a = clock;
    }

    public static Utils getInstance() {
        return getInstance(SystemClock.getInstance());
    }

    public long currentTimeInMillis() {
        return this.f15586a.currentTimeMillis();
    }

    public long currentTimeInSecs() {
        return TimeUnit.MILLISECONDS.toSeconds(currentTimeInMillis());
    }

    public long getRandomDelayForSyncPrevention() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean isAuthTokenExpired(@NonNull PersistedInstallationEntry persistedInstallationEntry) {
        if (TextUtils.isEmpty(persistedInstallationEntry.getAuthToken())) {
            return true;
        }
        if (persistedInstallationEntry.getExpiresInSecs() + persistedInstallationEntry.getTokenCreationEpochInSecs() < currentTimeInSecs() + AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS) {
            return true;
        }
        return false;
    }

    public static Utils getInstance(Clock clock) {
        if (f15585c == null) {
            f15585c = new Utils(clock);
        }
        return f15585c;
    }
}
