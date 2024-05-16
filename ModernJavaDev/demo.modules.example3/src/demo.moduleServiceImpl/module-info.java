module demo.moduleServiceImpl {

    requires demo.moduleService;

    provides packageService.GreetingService with
        packageServiceImpl.GreetingServiceImpl;
}