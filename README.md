## 使用微信推送

1. 新建文件application-dev.yaml
2. 填入

```yaml
custom:
  token: ${token here}
```

## 快捷键配置
1. sop System.out.println();
2. linf logger.info();
3. annotation <abbreviation> / 
4. cm  
```java
   /**
   * @title $name$
   * $params$
   * @return $returns$
   * @author ctc2811
   * @describe: 
   * @date $date$ $time$
   */
```   
   - name  methodName()
   - params  groovyScript("   def result='';    def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList();     for(i = 0; i < params.size(); i++) {         if(i!=0)result+= ' * ';         result+='@param ' + params[i] + ((i < (params.size() - 1)) ? '\\n' + '\\t' : '');     };     return result", methodParameters())
   - returns  methodReturnType()
   - date  date()
   - time  time()
5. 
```java
    /**
    * @name: ${NAME}
    * @description: 功能描述 - ${NAME} --
    * @author: chengtianci 
    * @date: ${DATE} ${TIME}
    */ 
```
