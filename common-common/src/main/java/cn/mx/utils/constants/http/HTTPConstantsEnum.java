package cn.mx.utils.constants.http;

import lombok.Getter;

/**
 * @author SSS
 * @create 2023/3/9
 */

@Getter
public enum HTTPConstantsEnum  implements HTTPConstants{


    SUSSES(200L, "success", "操作成功"),
    ERROR(500L, "error", "操作失败");

    private final Long code;
    private final String englishDesc;
    private final String chineseDesc;

    HTTPConstantsEnum(Long code, String englishDesc, String chineseDesc) {
        this.code = code;
        this.englishDesc = englishDesc;
        this.chineseDesc = chineseDesc;
    }

    @Override
    public Long getCode() {
        return this.code;
    }

    @Override
    public String getChineseDesc() {
        return this.chineseDesc;
    }

    @Override
    public String getEnglishDesc() {
        return this.englishDesc;
    }

    /**
     * 根据参数获取返回值，将返回值以json格式的方式输出
     * <p>
     * 这里使用到了final关键字，防止type指向新的引用对象
     *
     * @param type 用户传入的枚举的参数，比如ReturnCodeEnum.SUCCESS，ReturnCodeEnum.ERROR
     * @return
     */
    public static String StringToJson(final Object type) {
        if (null == type || type.equals(""))
            return "{'code':'-100000','englishDesc':'type is null','chineseDesc':'类型为空'}";

        for (HTTPConstantsEnum returnCodeEnum : HTTPConstantsEnum.values()) {
            String name = returnCodeEnum.name();
            if (name.equals(type.toString())) {
                return "{'code':'" + returnCodeEnum.getCode()
                        + "','chineseDesc':'" + returnCodeEnum.getChineseDesc()
                        + "','englishDesc':'" + returnCodeEnum.getEnglishDesc()
                        + "'}";
            }
        }
        return "{'code':'-200000','englishDesc':'parameter is error ','chineseDesc':'参数类型错误'}";
    }

}
