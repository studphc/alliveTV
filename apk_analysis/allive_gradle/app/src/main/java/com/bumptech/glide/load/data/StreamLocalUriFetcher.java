package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {

    /* renamed from: d */
    public static final UriMatcher f8659d;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f8659d = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public StreamLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public void close(InputStream inputStream) {
        inputStream.close();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025 A[RETURN] */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InputStream loadResource(Uri uri, ContentResolver contentResolver) {
        InputStream openContactPhotoInputStream;
        int match = f8659d.match(uri);
        if (match != 1) {
            if (match == 3) {
                openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
            } else if (match != 5) {
                openContactPhotoInputStream = contentResolver.openInputStream(uri);
            }
            if (openContactPhotoInputStream == null) {
                return openContactPhotoInputStream;
            }
            throw new FileNotFoundException("InputStream is null for " + uri);
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, lookupContact, true);
            if (openContactPhotoInputStream == null) {
            }
        } else {
            throw new FileNotFoundException("Contact cannot be found");
        }
    }
}
