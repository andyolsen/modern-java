module demo.moduleServiceClient {
    exports packageServiceClient;
    requires demo.moduleService;
    uses packageService.GreetingService;
}