package rocksdb.jna;

import java.nio.ByteBuffer;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

public interface RocksDBWrapper extends Library {

    Pointer dbOpen(String dbPath, Options opts, IntByReference statusCode,
            PointerByReference errorMsg);

    Pointer _get(Pointer dbReference, ByteBuffer keyBuf, int keyLen,
            ReadOptions readOpts, IntByReference valueLen,
            IntByReference statusCode, PointerByReference errorMsg);

    void _put(Pointer dbReference, ByteBuffer keyBuf, int keyLen,
            ByteBuffer valueBuf, int valueLen, WriteOptions writeOpts,
            IntByReference statusCode, PointerByReference errorMsg);

    void _delete(Pointer dbReference, ByteBuffer keyBuf, int keyLen,
            WriteOptions writeOpts, IntByReference statusCode,
            PointerByReference errorMsg);

    void dbClose(Pointer dbReference);

    void freePointer(Pointer memory);

    Pointer openIterator(Pointer dbReference, ReadOptions readOpts);

    boolean hasNext(Pointer itrReference);

    Pointer next(Pointer itrReference, IntByReference keyLen,
            IntByReference entryLen);

    Pointer openRangeIterator(Pointer dbReference, ReadOptions readOpts,
            ByteBuffer startKeyBuf, int startKeyLen);

    boolean hasRangeNext(Pointer itrReference, ByteBuffer endKeyBuf,
            int endKeyLen);

    void closeIterator(Pointer itrReference);
}
