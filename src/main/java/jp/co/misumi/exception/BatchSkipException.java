/**
 *       更新日     開発会社名     更新内容
 *    2017/03/06   misumi       新規追加
 *
 */
package jp.co.misumi.exception;

public class BatchSkipException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BatchSkipException(String message) {
        super(message);
    }
}