package cn.mx.utils.error;

/**
 * @ClassName: UtilException
 * @Author: SSS
 * @date: 2023/3/13 0:40
 */
public class UtilException extends RuntimeException{

    private static final long serialVersionUID = 8247610319171014183L;

    public UtilException(Throwable e)
    {
        super(e.getMessage(), e);
    }

    public UtilException(String message)
    {
        super(message);
    }

    public UtilException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
