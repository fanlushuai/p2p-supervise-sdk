# p2p-supervise-sdk
P2P网贷机构实时数据接入平台 （互联网应急中心）sdk retrofit封装。非常方便的集成到spring里面

## maven 配置

    <dependencies>

        <dependency>
            <groupId>com.open.sdk</groupId>
            <artifactId>p2p-supervise-sdk</artifactId>
            <version>1.1</version>
        </dependency>

    </dependencies>

    <repositories>

        <repository>
            <id>maven-repo</id>
            <url>https://raw.githubusercontent.com/fanlushuai/maven-repo/master/</url>
        </repository>

    </repositories>


## 使用
  参见test代码。配置自家apikey和sourceCode。即可使用。
  
  
    @Value("${app.profile}")
    private String profile;

    @Value("${cncrt.apiKey}")
    private String apiKey;

    @Value("${cncrt.sourceCode}")
    private String sourceCode;

    @Value("${cncrt.host}")
    private String host;

    @Value("${cncrt.version}")
    private String version;

    /**
     * 所有配置参数就在这里
     */
    @Bean
    public ConfigStorage configStorage() {
        return ConfigStorage.builder().apiKey(apiKey).host(host).sourceCode(sourceCode).version(version)
                .cncrtEnv(CNCRTEnv.TEST)//环境自己看着配置
                .build();
    }

    @Bean
    public Retrofit retrofit(ConfigStorage configStorage) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.connectTimeout(60, TimeUnit.SECONDS) //链接超时
                .writeTimeout(60, TimeUnit.SECONDS)   //写超时
                .readTimeout(60, TimeUnit.SECONDS)    //响应超时
                .retryOnConnectionFailure(false);     //取消重试

        builder.addInterceptor(new ApiKeyGenerateInterceptor(configStorage));

        if (!configStorage.getCncrtEnv().equals(CNCRTEnv.ONLINE_PRODUCT)) {
            //非线上正式环境都打印http日志
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        OkHttpClient client = builder.build();

        return new Retrofit.Builder()
                .baseUrl(configStorage.getHost())
                .addConverterFactory(GsonConverterFactory.create(configStorage.getCncrtEnv()))
                .client(client)
                .build();
    }

    /**
     * 注入接口服务类 
     */
    @Bean
    public UploadService uploadService(Retrofit retrofit) {
        return retrofit.create(UploadService.class);
    }

    /**
     * 注入批次接口服务类 
     */
    @Bean
    public ReconciliationService reconciliationService(Retrofit retrofit) {
        return retrofit.create(ReconciliationService.class);
    }
   
  
    
    
    
    
