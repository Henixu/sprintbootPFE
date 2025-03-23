import { MenuItem } from "./menu.model";

export const MENU: MenuItem[] = [
    {
        id: 1,
        label: 'MENU',
        isTitle: true
    },
    {
        id: 2,
        label: 'DASHBOARD',
        icon: 'ti ti-brand-google-home',
        subItems: [
            {
                id: 3,
                label: 'ANALYTICS',
                link: '/',
                parentId: 2
            },
        ]
    },
]