package mvc.lookup;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDatasource extends AbstractRoutingDataSource
{

    @Override
    protected Object determineCurrentLookupKey()
    {
        return FilebaseContextHolder.getCustomDatasource();
    }

    public static class FilebaseContextHolder
    {

        private static final ThreadLocal<ServerType> contextHolder = new ThreadLocal<ServerType>();

        public static void setServerType(ServerType serverType)
        {
            contextHolder.set(serverType);
        }

        public static ServerType getCustomDatasource()
        {
            return (ServerType) contextHolder.get();
        }

        public static void clearCustomDatasource()
        {
            contextHolder.remove();
        }
    }

    public enum ServerType
    {
        DB, App
    }

}
