package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class PersistedInstallation {

    /* renamed from: a */
    public File f15598a;

    /* renamed from: b */
    public final FirebaseApp f15599b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes2.dex */
    public static final class RegistrationStatus {
        public static final RegistrationStatus ATTEMPT_MIGRATION;
        public static final RegistrationStatus NOT_GENERATED;
        public static final RegistrationStatus REGISTERED;
        public static final RegistrationStatus REGISTER_ERROR;
        public static final RegistrationStatus UNREGISTERED;

        /* renamed from: a */
        public static final /* synthetic */ RegistrationStatus[] f15600a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Enum, com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus] */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus] */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Enum, com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, com.google.firebase.installations.local.PersistedInstallation$RegistrationStatus] */
        static {
            ?? r5 = new Enum("ATTEMPT_MIGRATION", 0);
            ATTEMPT_MIGRATION = r5;
            ?? r6 = new Enum("NOT_GENERATED", 1);
            NOT_GENERATED = r6;
            ?? r7 = new Enum("UNREGISTERED", 2);
            UNREGISTERED = r7;
            ?? r8 = new Enum("REGISTERED", 3);
            REGISTERED = r8;
            ?? r9 = new Enum("REGISTER_ERROR", 4);
            REGISTER_ERROR = r9;
            f15600a = new RegistrationStatus[]{r5, r6, r7, r8, r9};
        }

        public static RegistrationStatus valueOf(String str) {
            return (RegistrationStatus) Enum.valueOf(RegistrationStatus.class, str);
        }

        public static RegistrationStatus[] values() {
            return (RegistrationStatus[]) f15600a.clone();
        }
    }

    public PersistedInstallation(@NonNull FirebaseApp firebaseApp) {
        this.f15599b = firebaseApp;
    }

    /* renamed from: a */
    public final File m4394a() {
        if (this.f15598a == null) {
            synchronized (this) {
                try {
                    if (this.f15598a == null) {
                        this.f15598a = new File(this.f15599b.getApplicationContext().getFilesDir(), "PersistedInstallation." + this.f15599b.getPersistenceKey() + ".json");
                    }
                } finally {
                }
            }
        }
        return this.f15598a;
    }

    public void clearForTesting() {
        m4394a().delete();
    }

    @NonNull
    public PersistedInstallationEntry insertOrUpdatePersistedInstallationEntry(@NonNull PersistedInstallationEntry persistedInstallationEntry) {
        File createTempFile;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", persistedInstallationEntry.getFirebaseInstallationId());
            jSONObject.put("Status", persistedInstallationEntry.getRegistrationStatus().ordinal());
            jSONObject.put("AuthToken", persistedInstallationEntry.getAuthToken());
            jSONObject.put("RefreshToken", persistedInstallationEntry.getRefreshToken());
            jSONObject.put("TokenCreationEpochInSecs", persistedInstallationEntry.getTokenCreationEpochInSecs());
            jSONObject.put("ExpiresInSecs", persistedInstallationEntry.getExpiresInSecs());
            jSONObject.put("FisError", persistedInstallationEntry.getFisError());
            createTempFile = File.createTempFile("PersistedInstallation", "tmp", this.f15599b.getApplicationContext().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
        } catch (IOException | JSONException unused) {
        }
        if (!createTempFile.renameTo(m4394a())) {
            throw new IOException("unable to rename the tmpfile to PersistedInstallation");
        }
        return persistedInstallationEntry;
    }

    @NonNull
    public PersistedInstallationEntry readPersistedInstallationEntryValue() {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(m4394a());
            while (true) {
                try {
                    int read = fileInputStream.read(bArr, 0, 16384);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused) {
            jSONObject = new JSONObject();
        }
        String optString = jSONObject.optString("Fid", null);
        int optInt = jSONObject.optInt("Status", RegistrationStatus.ATTEMPT_MIGRATION.ordinal());
        String optString2 = jSONObject.optString("AuthToken", null);
        String optString3 = jSONObject.optString("RefreshToken", null);
        long optLong = jSONObject.optLong("TokenCreationEpochInSecs", 0L);
        long optLong2 = jSONObject.optLong("ExpiresInSecs", 0L);
        return PersistedInstallationEntry.builder().setFirebaseInstallationId(optString).setRegistrationStatus(RegistrationStatus.values()[optInt]).setAuthToken(optString2).setRefreshToken(optString3).setTokenCreationEpochInSecs(optLong).setExpiresInSecs(optLong2).setFisError(jSONObject.optString("FisError", null)).build();
    }
}
