package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseException;

/* loaded from: classes2.dex */
public class FirebaseInstallationsException extends FirebaseException {

    /* renamed from: a */
    public final Status f15580a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes2.dex */
    public static final class Status {
        public static final Status BAD_CONFIG;
        public static final Status TOO_MANY_REQUESTS;
        public static final Status UNAVAILABLE;

        /* renamed from: a */
        public static final /* synthetic */ Status[] f15581a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [com.google.firebase.installations.FirebaseInstallationsException$Status, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.google.firebase.installations.FirebaseInstallationsException$Status, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r5v1, types: [com.google.firebase.installations.FirebaseInstallationsException$Status, java.lang.Enum] */
        static {
            ?? r3 = new Enum("BAD_CONFIG", 0);
            BAD_CONFIG = r3;
            ?? r4 = new Enum("UNAVAILABLE", 1);
            UNAVAILABLE = r4;
            ?? r5 = new Enum("TOO_MANY_REQUESTS", 2);
            TOO_MANY_REQUESTS = r5;
            f15581a = new Status[]{r3, r4, r5};
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) f15581a.clone();
        }
    }

    public FirebaseInstallationsException(@NonNull Status status) {
        this.f15580a = status;
    }

    @NonNull
    public Status getStatus() {
        return this.f15580a;
    }

    public FirebaseInstallationsException(@NonNull String str, @NonNull Status status) {
        super(str);
        this.f15580a = status;
    }

    public FirebaseInstallationsException(@NonNull String str, @NonNull Status status, @NonNull Throwable th) {
        super(str, th);
        this.f15580a = status;
    }
}
